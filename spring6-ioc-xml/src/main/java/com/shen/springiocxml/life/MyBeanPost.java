package com.shen.springiocxml.life;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * 后置处理器
 */
public class MyBeanPost implements BeanPostProcessor {
    private static final Logger logger = LoggerFactory.getLogger(MyBeanPost.class);

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        logger.info("3.bean后置处理器，初始化之前执行");
        logger.info("bean name:[{}],bean is [{}]", beanName, bean);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        logger.info("5.bean后置处理器，初始化之后执行");
        logger.info("bean name:[{}],bean is [{}]", beanName, bean);
        return bean;
    }

}
