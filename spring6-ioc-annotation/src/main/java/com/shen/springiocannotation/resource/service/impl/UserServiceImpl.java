package com.shen.springiocannotation.resource.service.impl;

import com.shen.springiocannotation.resource.dao.UserDao;
import com.shen.springiocannotation.resource.service.UserService;
import jakarta.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service("myUserService")
public class UserServiceImpl implements UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    //没有指定名称根据属性名进行注入
    @Resource
    private UserDao myUserDao;


    @Override
    public void printHello() {
        logger.info("业务层调用打印方法");
        myUserDao.printHello();
    }
}
