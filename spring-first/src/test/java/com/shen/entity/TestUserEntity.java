package com.shen.entity;

import com.shen.springdemo.entity.UserEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * 测试User实体类
 */
class TestUserEntity {
    public static final Logger logger = LoggerFactory.getLogger(TestUserEntity.class);

    @Test
    void normalUser() {
        UserEntity userEntity = new UserEntity();
        userEntity.printHello();
        Assertions.assertTrue(true);
    }

    @Test
    void springUser() {
        //加载Spring配置文件，对象创建，本质是通过反射创建
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        //获取创建的对象
        UserEntity user = (UserEntity) context.getBean("userEntity");
        //使用对象调用方法
        user.printHello();
        Assertions.assertTrue(true);
    }

    @Test
    void reflectionUser() throws Exception {
        Class<?> cls = Class.forName("com.shen.springdemo.entity.UserEntity");
        Constructor<?> constructor = cls.getConstructor();
        Object object = constructor.newInstance();
        Method method = cls.getMethod("printHello");
        method.invoke(object);
    }
}
