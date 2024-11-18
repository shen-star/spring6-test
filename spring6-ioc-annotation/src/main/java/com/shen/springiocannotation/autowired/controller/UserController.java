package com.shen.springiocannotation.autowired.controller;

import com.shen.springiocannotation.autowired.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    //注入Service
    //第一种方式 属性注入-根据属性类型找到对应对象，完成注入 不用构建set方法
//    @Autowired
//    private UserService userService;

//    //第二种方式s et方法注入
//    private UserService userService;
//
//    @Autowired
//    public void setUserService(UserService userService) {
//        this.userService = userService;
//    }

////    第三种方式 构造方法注入
//    private UserService userService;
//
//    @Autowired
//    public UserController(UserService userService) {
//        this.userService = userService;
//    }

    //第四种方式 形参上注入
    private UserService userService;

    public UserController(@Autowired UserService userService) {
        this.userService = userService;
    }

    public void printHello() {
        logger.info("控制层调用打印方法");
        userService.printHello();
    }
}
