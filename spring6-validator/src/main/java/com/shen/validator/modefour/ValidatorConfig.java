package com.shen.validator.modefour;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;

/**
 * 配置类
 */
@Configuration
@ComponentScan("com.shen.validator.modefour")
public class ValidatorConfig {

    @Bean
    public MethodValidationPostProcessor vaildator() {
        return new MethodValidationPostProcessor();
    }
}
