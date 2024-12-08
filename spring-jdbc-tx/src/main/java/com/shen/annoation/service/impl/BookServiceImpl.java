package com.shen.annoation.service.impl;

import com.shen.annoation.dao.BookDao;
import com.shen.annoation.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BookServiceImpl implements BookService {
    private static final Logger logger = LoggerFactory.getLogger(BookServiceImpl.class);
    @Autowired
    private BookDao bookDao;

    @Override
    public void buyBook(Integer bookId, Integer userId) {
        // 查询书的价格
        Integer bookPrice = bookDao.getBookPriceById(bookId);
        logger.info("图书价格为:{}", bookPrice);

        //更新图书库存
        bookDao.updateBookStock(bookId);

        //更新用户余额
        bookDao.updateUserBalance(userId, bookPrice);
    }
}
