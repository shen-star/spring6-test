package com.shen.springiocannotation.autowired.service.impl;

import com.shen.springiocannotation.autowired.dao.UserDao;
import com.shen.springiocannotation.autowired.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserDao userDao;

    @Override
    public void printHello() {
        logger.info("业务层调用打印方法");
        userDao.printHello();
    }
}
