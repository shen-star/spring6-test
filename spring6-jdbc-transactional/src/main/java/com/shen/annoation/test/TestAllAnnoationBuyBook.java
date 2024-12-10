package com.shen.annoation.test;

import com.shen.annoation.config.SpringConfig;
import com.shen.annoation.controller.BookController;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestAllAnnoationBuyBook {
    @Test
    void buyBook() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);
        BookController bookController = applicationContext.getBean(BookController.class);
        bookController.buyBook(1, 1);
    }
}
