package com.shen.shouxieioc.dao.impl;

import com.shen.shouxieioc.annoation.Bean;
import com.shen.shouxieioc.dao.UserDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Bean
public class UserDaoImpl implements UserDao {
    private static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);

    @Override
    public void printDao() {
        logger.info("dao print ==========");
    }
}
