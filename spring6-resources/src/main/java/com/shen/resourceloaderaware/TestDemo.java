package com.shen.resourceloaderaware;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ResourceLoader;

public class TestDemo {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        TestBean testBean = context.getBean(TestBean.class);
        ResourceLoader resourceLoader = testBean.getResourceLoader();
        System.out.println(context == resourceLoader);
    }
}
