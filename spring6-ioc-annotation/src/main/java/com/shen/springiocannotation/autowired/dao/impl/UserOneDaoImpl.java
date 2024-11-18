package com.shen.springiocannotation.autowired.dao.impl;

import com.shen.springiocannotation.autowired.dao.UserDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository
public class UserOneDaoImpl implements UserDao {
    private static final Logger logger = LoggerFactory.getLogger(UserOneDaoImpl.class);

    @Override
    public void printHello() {
        logger.info("one");
    }
}
