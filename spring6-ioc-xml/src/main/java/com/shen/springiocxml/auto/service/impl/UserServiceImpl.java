package com.shen.springiocxml.auto.service.impl;

import com.shen.springiocxml.auto.dao.UserDao;
import com.shen.springiocxml.auto.dao.impl.UserDaoImpl;
import com.shen.springiocxml.auto.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 用户业务实现类
 */
public class UserServiceImpl implements UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void invokeDaoMethod() {
        logger.info("业务层对象调用Dao方法");
        //常规调用方式
//        UserDao userDao = new UserDaoImpl();
//        userDao.printHello();

        userDao.printHello();
    }
}
