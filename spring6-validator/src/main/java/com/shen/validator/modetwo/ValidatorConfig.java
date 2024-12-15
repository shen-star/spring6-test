package com.shen.validator.modetwo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

/**
 * 配置类
 */
@Configuration
@ComponentScan("com.shen.validator.modetwo")
public class ValidatorConfig {

    @Bean
    public LocalValidatorFactoryBean vaildator() {
        return new LocalValidatorFactoryBean();
    }
}
