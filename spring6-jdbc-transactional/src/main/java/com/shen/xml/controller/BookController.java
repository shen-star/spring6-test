package com.shen.xml.controller;

import com.shen.xml.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class BookController {
    @Autowired
    private BookService bookService;

    /**
     * 买书的方法
     *
     * @param bookId 图书id
     * @param userId 用户id
     */
    public void buyBook(Integer bookId, Integer userId) {
        bookService.buyBook(bookId, userId);
    }
}
