package com.shen.shouxieioc.service.impl;

import com.shen.shouxieioc.annoation.Bean;
import com.shen.shouxieioc.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Bean
public class UserServiceImpl implements UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public void printService() {
        logger.info("print service ==============");
    }
}
