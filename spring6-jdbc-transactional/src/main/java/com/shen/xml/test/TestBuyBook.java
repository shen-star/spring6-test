package com.shen.xml.test;

import com.shen.xml.controller.BookController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(locations = "classpath:bean-xml.xml")
public class TestBuyBook {
    @Autowired
    private BookController bookController;

    @Test
    void buyBook() {
        bookController.buyBook(1, 1);
    }
}
