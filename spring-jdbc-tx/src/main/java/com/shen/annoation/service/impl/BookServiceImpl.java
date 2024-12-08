package com.shen.annoation.service.impl;

import com.shen.annoation.dao.BookDao;
import com.shen.annoation.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
//事务属性-只读
//@Transactional(readOnly = true)
//事务属性-超时3秒直接返回，-1则为没有超时时间
//@Transactional(timeout = 3)
//事务属性-设置回滚策略，针对运行时异常回滚，rollbackFor 设置哪些异常回滚，noRollbackFor 设置哪些不进行回滚
//@Transactional(noRollbackFor = ArithmeticException.class)
//事务属性设置隔离级别 READ_UNCOMMITTED 读未提交 ，READ_COMMITTED 读已提交 ，REPEATABLE_READ 可重复读 ，SERIALIZABLE 串行化，DEFAULT按数据库默认隔离级别
//@Transactional(isolation = Isolation.READ_COMMITTED)
//事务属性-事务的传播行为 总共7种，常见的 REQUIRED 支持当前事务，如果不存在就新建一个 。REQUIRES_NEW 开启一个新事务
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class BookServiceImpl implements BookService {
    private static final Logger logger = LoggerFactory.getLogger(BookServiceImpl.class);
    @Autowired
    private BookDao bookDao;

    @Override
    public void buyBook(Integer bookId, Integer userId) {

        //测试超时
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            logger.error("", e);
//            Thread.currentThread().interrupt();
//        }
        // 查询书的价格
        Integer bookPrice = bookDao.getBookPriceById(bookId);
        logger.info("图书价格为:{}", bookPrice);

        //更新图书库存
        bookDao.updateBookStock(bookId);

        //更新用户余额
        bookDao.updateUserBalance(userId, bookPrice);
//        测试异常不回滚
//        int a = 1 / 0;
    }
}
