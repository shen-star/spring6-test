package com.shen.resourceloader;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.Resource;

/**
 * 使用ResourceLoader来获取Resource实例
 * resourceloader可以根据ApplicationContext的不同类型获取到不同类型的Resource，也可以通过传参的前缀来指定Resource
 */
public class ResourceLoaderDemo {
    /**
     * 根据ApplicationContext实现类的类型获取Resource
     */
    @Test
    void demo1() {
        ApplicationContext context = new ClassPathXmlApplicationContext();
        Resource resource = context.getResource("test-class-resource");
        System.out.println(resource.getFilename());
        System.out.println(resource.getDescription());
    }

    @Test
    void demo2() {
        ApplicationContext context = new FileSystemXmlApplicationContext();
        Resource resource = context.getResource("test-class-resource");
        System.out.println(resource.getFilename());
        System.out.println(resource.getDescription());
    }

    /**
     * 根据前缀获取指定Resource
     */
    @Test
    void demo3() {
        ApplicationContext context = new FileSystemXmlApplicationContext();
        Resource resource1 = context.getResource("classpath:test-class-resource");
        System.out.println(resource1.getDescription());
        Resource resource2 = context.getResource("http://baidu.com");
        System.out.println(resource2.getDescription());
        Resource resource3 = context.getResource("resources-test.txt");
        System.out.println(resource3.getDescription());
    }
}
