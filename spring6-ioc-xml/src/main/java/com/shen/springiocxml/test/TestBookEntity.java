package com.shen.springiocxml.test;

import com.shen.springiocxml.entity.BookEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 测试书实体类 依赖注入setting和构造器两种方式
 */
public class TestBookEntity {
    private static final Logger logger = LoggerFactory.getLogger(TestBookEntity.class);

    public static void main(String[] args) {
        //常规方式注入的两种方式(set和全参构造器)
        BookEntity bookEntity1 = new BookEntity();
        bookEntity1.setName("语文");
        bookEntity1.setAuthor("小明");
        logger.info("常规方式注入-set方式，对象打印:{}", bookEntity1);
        BookEntity bookEntity2 = new BookEntity("数学", "小李");
        logger.info("常规方式注入-全参构造器方式，对象打印:{}", bookEntity2);

        ApplicationContext context = new ClassPathXmlApplicationContext("bean-di.xml");
        //spring基于xml方式 set注入方式
        BookEntity bookEntity3 = context.getBean("bookEntity3", BookEntity.class);
        logger.info("ioc注入-set方式，对象打印:{}", bookEntity3);
        //spring基于xml方式 全参构造器注入方式
        BookEntity bookEntity4 = context.getBean("bookEntity4", BookEntity.class);
        logger.info("ioc注入-全参构造器方式，对象打印:{}", bookEntity4);
    }
}
