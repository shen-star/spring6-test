package com.shen.springiocannotation.autowired.service.impl;

import com.shen.springiocannotation.autowired.dao.UserDao;
import com.shen.springiocannotation.autowired.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

//    @Autowired
//    private UserDao userDao;

    //第六种方式 @Autowired和@Qualifier注解 根据名称自动装配
    @Autowired
    @Qualifier(value = "userOneDaoImpl")
    private UserDao userDao;

    @Override
    public void printHello() {
        logger.info("业务层调用打印方法");
        userDao.printHello();
    }
}
