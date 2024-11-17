package com.shen.springiocxml.test;

import com.alibaba.druid.pool.DruidDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 测试druid数据源配置
 */
public class TestDruidDataSource {
    private static final Logger logger = LoggerFactory.getLogger(TestDruidDataSource.class);

    public static void main(String[] args) {
        //常规方式生成Druid数据源对象
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setUsername("root");
        druidDataSource.setPassword("123456");
        druidDataSource.setUrl("jdbc:mysql://localhost:3306/test?serverTimezone=UTC");
        druidDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        logger.info("常规方式生成DruidDataSource对象的url: {}", druidDataSource.getUrl());
        //spring方式生成Druid数据源对象
        ApplicationContext context = new ClassPathXmlApplicationContext("bean-jdbc.xml");
        DruidDataSource druidDataSource1 = context.getBean("druidDataSourceOne", DruidDataSource.class);
        logger.info("spring方式生成DruidDataSource对象的url: {}", druidDataSource1.getUrl());


    }
}
