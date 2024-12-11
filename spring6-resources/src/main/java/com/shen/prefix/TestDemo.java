package com.shen.prefix;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;

/**
 * 通过前缀来指定ApplicationContext访问XML配置文件策略
 */
public class TestDemo {
    public static void main(String[] args) {
        //常规写法
//        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
//        Resource resource = context.getResource("test-class-resource.txt");
//        System.out.println(resource.getDescription());

        //指定前缀写法
//        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:bean.xml");
        //可以使用通配符来读取多个xml文件，比如查询多个classpath各个beanxx的配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath*:bean*.xml");
        User user = context.getBean(User.class);
        System.out.println(user);

    }
}
