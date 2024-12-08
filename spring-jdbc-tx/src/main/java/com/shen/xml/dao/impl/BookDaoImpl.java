package com.shen.xml.dao.impl;

import com.shen.xml.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BookDaoImpl implements BookDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Integer getBookPriceById(Integer bookId) {
        String selectPriceSql = "select price from book where book_id = ?";
        return jdbcTemplate.queryForObject(selectPriceSql, Integer.class, bookId);
    }

    @Override
    public void updateBookStock(Integer bookId) {
        String updateStackSql = "update book set stock = stock - 1 where book_id = ?";
        jdbcTemplate.update(updateStackSql, bookId);
    }

    @Override
    public void updateUserBalance(Integer userId, Integer bookPrice) {
        String updateBalanceSql = "update user set balance = balance - ? where user_id = ?";
        jdbcTemplate.update(updateBalanceSql, bookPrice, userId);
    }


}
