package com.shen.validator.modethree;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestMyValidator {
    @Test
    public void testValidator() {
        ApplicationContext context = new AnnotationConfigApplicationContext(ValidatorConfig.class);
        MyValidator myValidator = context.getBean(MyValidator.class);
        User user = new User();
        user.setName("alex");
        user.setAge(20);
        user.setPhone("13999999999");
        System.out.println(myValidator.testMethod(user));
    }
}
