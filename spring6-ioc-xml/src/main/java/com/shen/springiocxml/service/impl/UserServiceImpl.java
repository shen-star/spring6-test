package com.shen.springiocxml.service.impl;

import com.shen.springiocxml.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 接口实现类
 */
public class UserServiceImpl implements UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public void printRun() {
        logger.info("run====================");
    }
}
