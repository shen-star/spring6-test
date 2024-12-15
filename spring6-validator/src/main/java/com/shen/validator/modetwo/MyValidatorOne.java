package com.shen.validator.modetwo;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Set;

/**
 * 注入原生的校验器
 */
@Component
public class MyValidatorOne {
    @Autowired
    private Validator validator;

    /**
     * 返回是否有校验不通过的地方
     * @param user 用户实例
     * @return 是否有校验不通过的地方
     */
    public boolean validatorUser(User user) {
        Set<ConstraintViolation<User>> validate = validator.validate(user);
        for (ConstraintViolation<User> info : validate) {
            System.out.println(info.toString());
        }
        return validate.isEmpty();
    }
}
