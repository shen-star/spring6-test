package com.shen.springiocxml.test;

import com.shen.springiocxml.service.UserService;
import com.shen.springiocxml.service.impl.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 接口实现类测试
 */
public class TestUserServiceImpl {
    private static final Logger logger = LoggerFactory.getLogger(TestUserServiceImpl.class);

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        //根据类型获取接口对应的bean
        UserService userService = context.getBean(UserService.class);
        logger.info("userService instanceof UserServiceImpl result:{}", userService instanceof UserServiceImpl);
        logger.info("输出得到的对象:{}", userService);
        userService.printRun();
    }
}
