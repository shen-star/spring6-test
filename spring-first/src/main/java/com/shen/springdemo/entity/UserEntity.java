package com.shen.springdemo.entity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * 用户实体类
 */
public class UserEntity {
    public static final Logger logger = LoggerFactory.getLogger(UserEntity.class);

    public UserEntity() {
        logger.info("无参构造被执行了");
    }

    public void printHello() {
        System.out.println("hello");
    }
}
