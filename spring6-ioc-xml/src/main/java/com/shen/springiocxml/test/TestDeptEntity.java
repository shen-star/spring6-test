package com.shen.springiocxml.test;

import com.shen.springiocxml.entity.DeptEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 测试部门实体类
 */
public class TestDeptEntity {
    private static final Logger logger = LoggerFactory.getLogger(TestDeptEntity.class);

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean-collection-di.xml");
        DeptEntity deptEntityOne = context.getBean("deptEntityOne", DeptEntity.class);
        deptEntityOne.printEmpList();
    }
}
