package com.shen.springaop.xmlaop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 测试配置切面类后的方法执行结果
 */
public class TestLogAspect {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beanaop.xml");
        Calculator calculator = context.getBean(Calculator.class);
//        calculator.add(1, 2);
//        calculator.sub(2,3);
//        calculator.mul(1,2);
        calculator.div(2, 1);
    }
}
