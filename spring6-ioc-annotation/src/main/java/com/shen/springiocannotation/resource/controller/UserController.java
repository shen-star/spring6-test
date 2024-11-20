package com.shen.springiocannotation.resource.controller;

import com.shen.springiocannotation.resource.service.UserService;
import jakarta.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;

@Controller("myUserController")
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

//    //根据名称进行注入
//    @Resource(name = "myUserService")
//    private UserService userService;

    //既没有指定名字，属性名也不一致的情况下通过类型进行注入
    @Resource
    private UserService userService;



    public void printHello() {
        logger.info("控制层调用打印方法");
        userService.printHello();
    }
}
