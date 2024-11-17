package com.shen.springiocxml.life;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 测试类
 */
public class UserDemo {
    private static final Logger logger = LoggerFactory.getLogger(UserDemo.class);
    private String name;

    public UserDemo() {
        logger.info("1.调用无参数构造，创建bean对象");
    }

    public void initMethod() {
        logger.info("4.bean对象初始化，调用指定的初始化");
    }

    public void destroyMethod() {
        logger.info("7.bean对象销毁，调用指定销毁的方法");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        logger.info("2.对bean对象设置属性值");
        this.name = name;
    }

    @Override
    public String toString() {
        return "UserDemo{" +
                "name='" + name + '\'' +
                '}';
    }
}
