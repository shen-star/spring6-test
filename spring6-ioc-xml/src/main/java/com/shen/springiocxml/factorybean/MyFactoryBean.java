package com.shen.springiocxml.factorybean;

import org.springframework.beans.factory.FactoryBean;

/**
 * 自定义FactoryBean类
 */
public class MyFactoryBean implements FactoryBean<UserDemoTwo> {
    @Override
    public UserDemoTwo getObject() throws Exception {
        return new UserDemoTwo();
    }

    @Override
    public Class<?> getObjectType() {
        return UserDemoTwo.class;
    }
}
