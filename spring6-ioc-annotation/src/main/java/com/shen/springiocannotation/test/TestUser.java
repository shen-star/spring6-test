package com.shen.springiocannotation.test;

import com.shen.springiocannotation.bean.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 测试注解形式创建Bean
 */
public class TestUser {
    private static final Logger logger = LoggerFactory.getLogger(TestUser.class);

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        User user = context.getBean("user", User.class);
        logger.info("{}", user);
    }
}
