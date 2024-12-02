package com.shen.junit.junit5;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

//另一种方式
//@ExtendWith(SpringExtension.class)
//@ContextConfiguration("classpath:bean.xml")

//第一种方式推荐
@SpringJUnitConfig(locations = "classpath:bean.xml")
public class SpringTestJunit5 {

    private final User user;

    @Autowired
    public SpringTestJunit5(User user) {
        this.user = user;
    }

    @Test
    public void testUser() {
        user.printHello();
    }
}
