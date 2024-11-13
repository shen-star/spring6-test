package com.shen.springiocxml.test;

import com.shen.springiocxml.entity.EmpEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 测试emp实体类
 */
public class TestEmpEntity {
    public static final Logger logger = LoggerFactory.getLogger(TestEmpEntity.class);

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean-object-di.xml");
        EmpEntity empEntityOne = context.getBean("empEntityOne", EmpEntity.class);
        logger.info("emlEntityOne :{}", empEntityOne);
        EmpEntity empEntityTwo = context.getBean("empEntityTwo", EmpEntity.class);
        logger.info("emlEntityTwo :{}", empEntityTwo);
        EmpEntity empEntityThree = context.getBean("empEntityThree", EmpEntity.class);
        logger.info("empEntityThree :{}", empEntityThree);

        context = new ClassPathXmlApplicationContext("bean-array-di.xml");
        EmpEntity empEntity = context.getBean("empEntity", EmpEntity.class);
        logger.info("empEntity's hobby :");
        empEntity.printHobby();
    }
}
