package com.shen.shouxieioc.test;


import com.shen.shouxieioc.bean.AnnoationApplicationContext;
import com.shen.shouxieioc.bean.ApplicationContext;
import com.shen.shouxieioc.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestUser {
    private static final Logger logger = LoggerFactory.getLogger(TestUser.class);

    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnoationApplicationContext("com.shen.shouxieioc");
        UserService userService = (UserService) applicationContext.getBean(UserService.class);
        userService.printService();
    }
}
