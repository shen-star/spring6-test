package com.shen.validator.modetwo;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 测试两种校验器
 */
public class TestMyValidator {
    @Test
    public void TestValidatorOne() {
        ApplicationContext context = new AnnotationConfigApplicationContext(ValidatorConfig.class);
        MyValidatorOne myValidatorOne = context.getBean(MyValidatorOne.class);
        User user = new User();
        user.setName("alex");
        user.setAge(20);
        boolean message = myValidatorOne.validatorUser(user);
        System.out.println(message);
    }

    @Test
    public void TestValidatorTwo() {
        ApplicationContext context = new AnnotationConfigApplicationContext(ValidatorConfig.class);
        MyValidatorTwo myValidatorTwo= context.getBean(MyValidatorTwo.class);
        User user = new User();
//        user.setName("alex");
//        user.setAge(20);
        boolean message = myValidatorTwo.validatorUser(user);
        System.out.println(message);
    }
}
