package com.shen.annoation.test;

import com.shen.annoation.config.SpringConfig;
import com.shen.annoation.controller.BookController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(classes = SpringConfig.class)
public class TestAllAnnoationBuyBook {
    @Autowired
    private BookController bookController;

    @Test
    void buyBook() {
        bookController.buyBook(1, 1);
    }
}
