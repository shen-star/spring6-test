package com.shen.annoation.dao;

public interface BookDao {
    Integer getBookPriceById(Integer bookId);

    void updateBookStock(Integer bookId);

    void updateUserBalance(Integer userId, Integer bookPrice);
}
