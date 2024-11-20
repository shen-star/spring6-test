package com.shen.springiocannotation.resource.dao.impl;

import com.shen.springiocannotation.resource.dao.UserDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository("myUserDao")
public class UserDaoImpl implements UserDao {
    private static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);

    @Override
    public void printHello() {
        logger.info("数据传输层打印hello");
        logger.info("hello");
    }
}
