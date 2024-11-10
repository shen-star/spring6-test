package com.shen.springiocxml.entity;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 用户实体类
 */
public class UserEntity {
    private final static Logger logger = LoggerFactory.getLogger(UserEntity.class);
    private String id;
    private String name;

    public void printHello() {
        logger.info("hello");
    }
}
