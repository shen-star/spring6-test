package com.shen.validator.modefour;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestUser {
    @Test
    public void testValidator() {
        ApplicationContext context = new AnnotationConfigApplicationContext(ValidatorConfig.class);
        MyValidator myValidator = context.getBean(MyValidator.class);
        User user = new User();
        user.setName("alex");
        user.setAge(20);
        user.setMessage("hello world");
        System.out.println(myValidator.testMethod(user));
    }
}
