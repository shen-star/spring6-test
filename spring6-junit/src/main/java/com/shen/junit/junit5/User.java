package com.shen.junit.junit5;

import org.springframework.stereotype.Component;

/**
 * 用户实体类
 */
@Component
public class User {
    public void printHello() {
        System.out.println("hello");
    }
}
