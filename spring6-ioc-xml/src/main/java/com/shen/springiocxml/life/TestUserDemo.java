package com.shen.springiocxml.life;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 测试用户demo类
 */
public class TestUserDemo {
    private static final Logger logger = LoggerFactory.getLogger(TestUserDemo.class);

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean-life.xml");
        UserDemo userDemo = context.getBean("userDemo", UserDemo.class);
        logger.info("6.对象已创建，可以被使用");
        logger.info("{}", userDemo);
        context.close();
    }
}
