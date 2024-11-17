package com.shen.springiocxml.scope;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 测试bean中的scope作用域属性
 */
public class TestOrder {
    private static final Logger logger = LoggerFactory.getLogger(TestOrder.class);

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean-scope.xml");
        //单实例在spring容器初始化时创建
        OrderOne orderOne1 = context.getBean("orderOne", OrderOne.class);
        logger.info("单实例创建orderOne1对象的地址:{}", orderOne1);
        OrderOne orderOne2 = context.getBean("orderOne", OrderOne.class);
        logger.info("单实例创建orderOne2对象的地址:{}", orderOne2);
        //多实例在获取bean时创建
        OrderTwo orderTwo1 = context.getBean("orderTwo", OrderTwo.class);
        logger.info("多实例创建orderTwo1对象的地址:{}", orderTwo1);
        OrderTwo orderTwo2 = context.getBean("orderTwo", OrderTwo.class);
        logger.info("多实例创建orderTwo2对象的地址:{}", orderTwo2);
    }


}
