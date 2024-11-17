package com.shen.springiocxml.factorybean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 测试类
 */
public class TestUserDemoTwo {
    private static final Logger logger = LoggerFactory.getLogger(TestUserDemoTwo.class);

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean-factorybean.xml");
        UserDemoTwo testUserDemoTwo = (UserDemoTwo) context.getBean("userDemoTwo");
        logger.info("{}", testUserDemoTwo);

    }
}
