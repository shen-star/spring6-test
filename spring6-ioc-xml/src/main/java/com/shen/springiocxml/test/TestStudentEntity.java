package com.shen.springiocxml.test;

import com.shen.springiocxml.entity.StudentEntity;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 测试学生实体类
 */
public class TestStudentEntity {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean-collection-map-di.xml");
        StudentEntity studentEntityOne = context.getBean("studentEntityOne", StudentEntity.class);
        studentEntityOne.printStudentInfo();
    }
}
