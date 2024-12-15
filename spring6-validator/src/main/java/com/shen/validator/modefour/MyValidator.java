package com.shen.validator.modefour;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

/**
 * 基于方法实现校验
 */
@Component
@Validated
public class MyValidator {
    public String testMethod(@NotNull @Valid User user) {
        return user.toString();
    }
}
