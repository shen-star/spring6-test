package com.shen.springiocxml.auto.dao.impl;

import com.shen.springiocxml.auto.dao.UserDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 数据传输实现类
 */
public class UserDaoImpl implements UserDao {
    private static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);

    @Override
    public void printHello() {
        logger.info("数据传输对象打印hello");
        logger.info("hello");
    }
}
