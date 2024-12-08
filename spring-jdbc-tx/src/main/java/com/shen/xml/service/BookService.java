package com.shen.xml.service;

public interface BookService {

    /**
     * 买一本书
     *
     * @param bookId 图片id
     * @param userId 用户id
     */
    void buyBook(Integer bookId, Integer userId);
}
