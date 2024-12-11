package com.shen.resourcedi;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestDemo {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean-resource.xml");
        ResourceBean resourceBean = context.getBean(ResourceBean.class);
        resourceBean.printResourceInfo();
    }
}
