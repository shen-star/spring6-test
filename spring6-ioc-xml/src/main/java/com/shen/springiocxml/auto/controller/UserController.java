package com.shen.springiocxml.auto.controller;

import com.shen.springiocxml.auto.dao.impl.UserDaoImpl;
import com.shen.springiocxml.auto.service.UserService;
import com.shen.springiocxml.auto.service.impl.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 用户控制层接口类
 */
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    private UserService userService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public void invokeServiceMethod() {
        logger.info("控制层对象调用service方法");
        //常规调用方式
//        UserService userService = new UserServiceImpl();
//        userService.invokeDaoMethod();
        userService.invokeDaoMethod();


    }

}
