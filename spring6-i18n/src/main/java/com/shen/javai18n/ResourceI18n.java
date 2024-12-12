package com.shen.javai18n;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * java实现国际化测试
 */
public class ResourceI18n {
    public static void main(String[] args) {
        //message命名规范是 文件名_语言_国家
        ResourceBundle zhBundle = ResourceBundle.getBundle("message",
                new Locale("zh", "CN"));
        System.out.println("CN:" + zhBundle.getString("test"));

        ResourceBundle enBundle = ResourceBundle.getBundle("message",
                new Locale("en", "GB"));
        System.out.println("GB:" + enBundle.getString("test"));
    }
}
