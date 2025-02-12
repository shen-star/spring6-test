package com.shen.shouxieioc.service.impl;

import com.shen.shouxieioc.annoation.Bean;
import com.shen.shouxieioc.annoation.Di;
import com.shen.shouxieioc.dao.UserDao;
import com.shen.shouxieioc.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Bean
public class UserServiceImpl implements UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Di
    private UserDao userDao;

    @Override
    public void printService() {
        logger.info("print service ==============");
        userDao.printDao();
    }
}
