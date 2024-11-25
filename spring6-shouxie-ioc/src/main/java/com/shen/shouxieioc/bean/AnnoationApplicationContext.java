package com.shen.shouxieioc.bean;

import com.shen.shouxieioc.annoation.Bean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.net.URL;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

public class AnnoationApplicationContext implements ApplicationContext {

    private final static Logger logger = LoggerFactory.getLogger(AnnoationApplicationContext.class);

    //创建map集合，存入bean对象
    private Map<Class<?>, Object> beanFactory = new HashMap<>();
    private String rootPath;

    @Override
    public Object getBean(Class<?> cls) {
        return beanFactory.get(cls);
    }

    //创建有参构造，传参为包路径，设置包扫描规则
    //当前包以及其子包，哪个类有@Bean注解，把这个类通过反射实例化
    public AnnoationApplicationContext(String basePackagePath) {
        try {
            //1.把.替换成\
            String packagePath = basePackagePath.replaceAll("\\.", "\\\\");

            //2.获取包的绝对路径
            Enumeration<URL> urls = Thread.currentThread().getContextClassLoader().getResources(packagePath);
            while (urls.hasMoreElements()) {
                URL url = urls.nextElement();
                String filePath = URLDecoder.decode(url.getFile(), StandardCharsets.UTF_8);
                rootPath = filePath.substring(0, filePath.length() - packagePath.length());
                loadBean(new File(filePath));
                logger.info("完成{}包扫描", basePackagePath);
            }
        } catch (Exception e) {
            logger.info("扫描包异常:", e);
        }
    }

    //包扫描方法
    private void loadBean(File file) throws Exception {
        //1. 判断当前是否为文件夹
        if (file.isDirectory()) {
            //2. 获取文件夹中所有内容
            File[] childFiles = file.listFiles();
            //3. 判断文件夹里面是否为空，不为空则遍历所有内容
            if (childFiles == null || childFiles.length == 0) {
                return;
            }
            for (File child : childFiles) {
                //4.1 遍历得到每个File对象，如果文件对象是文件夹则递归遍历
                if (child.isDirectory()) {
                    //递归
                    loadBean(child);
                } else {
                    //4.2 如果File对象是文件，则获取文件的绝对路径
                    String filePath = child.getAbsolutePath();
                    //4.3 判断当前文件路径是否带有.class
                    if (filePath.contains(".class")) {
                        //4.4 如果带有class则获取全类名
                        String pathWithClass = filePath.substring(rootPath.length() - 1).replaceAll("\\\\", ".");
                        String className = pathWithClass.replace(".class", "");
                        //4.5 通过全类名获取Class类对象
                        Class<?> cls = Class.forName(className);
                        ///4.6 判断是否为接口
                        if (!cls.isInterface()) {
                            Bean annotation = cls.getAnnotation(Bean.class);
                            //4.7 判断是否有Bean注解
                            if (annotation != null) {
                                Constructor<?> constructor = cls.getConstructor();
                                //4.8 实例化对象
                                Object object = constructor.newInstance();
                                //4.9 如果该类有接口，则取该类继承的一个接口作为key存入map集合中，反之则将该类作为key存入map集合中，value为实例
                                if (cls.getInterfaces().length > 0) {
                                    beanFactory.put(cls.getInterfaces()[0], object);
                                } else {
                                    beanFactory.put(cls, object);
                                }
                            }
                        }
                    }

                }
            }
        }
    }


    public static void main(String[] args) throws IOException {
        //1.把.替换成\
        String packagePath = "com.shen.shouxieioc".replaceAll("\\.", "\\\\");

        //2.获取包的绝对路径
        Enumeration<URL> urls = Thread.currentThread().getContextClassLoader().getResources(packagePath);
        while (urls.hasMoreElements()) {
            URL url = urls.nextElement();
            String filePath = URLDecoder.decode(url.getFile(), StandardCharsets.UTF_8);
            String rootPath = filePath.substring(0, filePath.length() - packagePath.length());
            logger.info(filePath);
            String classPath = filePath.substring(rootPath.length());
            String className = filePath.substring(rootPath.length()).replaceAll("\\\\", ".");
            logger.info(classPath);
        }
    }
}
