package com.shen.springiocxml.test;

import com.shen.springiocxml.entity.UserEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 测试用户实体类对象的创建
 */
public class TestUserEntity {
    private final static Logger logger = LoggerFactory.getLogger(TestUserEntity.class);

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        //1.根据id获取bean
        logger.info("根据id获取bean");
        UserEntity userEntity1 = (UserEntity) context.getBean("userEntity");
        userEntity1.printHello();
        logger.info("获取bean的hashcode:{}", userEntity1.hashCode());
        //2.根据类型获取bean
        logger.info("根据类型获取bean");
        UserEntity userEntity2 = context.getBean(UserEntity.class);
        userEntity2.printHello();
        logger.info("获取bean的hashcode:{}", userEntity2.hashCode());
        //3.根据id和类型获取bean
        logger.info("根据id和类型获取bean");
        UserEntity userEntity3 = context.getBean("userEntity", UserEntity.class);
        userEntity3.printHello();
        logger.info("获取bean的hashcode:{}", userEntity3.hashCode());
    }
}
