package com.shen.resources;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

/**
 * 访问类路径下的资源
 */
public class ClassPathResourceDemo {
    private static final Logger logger = LoggerFactory.getLogger(ClassPathResourceDemo.class);

    public static void main(String[] args) throws IOException {
        loadClassPathResource("test-class-resource.txt");
    }

    public static void loadClassPathResource(String path) throws IOException {
        //创建ClassPathResource对象
        ClassPathResource classPathResource = new ClassPathResource(path);

        //获取资源信息
        logger.info("获取文件名:{}", classPathResource.getFilename());
        logger.info("获取描述:{}", classPathResource.getDescription());
        InputStream inputStream = classPathResource.getInputStream();
        byte[] bytes = new byte[1024];
        int len;
        while ((len = inputStream.read(bytes)) != -1) {
            String s = new String(bytes, 0, len, StandardCharsets.UTF_8);
            logger.info("读取流的内容：{}", s);
        }
        inputStream.close();
    }
}
