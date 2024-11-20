package com.shen.springiocannotation.test;

import com.shen.springiocannotation.autowired.controller.UserController;
import com.shen.springiocannotation.config.Spring6Config;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestUserControllerByAnnotation {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Spring6Config.class);
        UserController userController = context.getBean(UserController.class);
        userController.printHello();
    }
}
