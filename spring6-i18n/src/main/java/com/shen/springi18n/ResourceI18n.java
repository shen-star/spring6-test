package com.shen.springi18n;

import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;
import java.util.Locale;

/**
 * spring实现国际化
 */
public class ResourceI18n {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        Object[] objects1 = {"shen", new Date().toString()};
        Object[] objects2 = {"alex", new Date().toString()};
        System.out.println(context.getMessage("msg", objects1, Locale.CHINA));
        System.out.println(context.getMessage("msg", objects2, Locale.UK));
    }
}
