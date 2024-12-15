package com.shen.validator.modetwo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindException;
import org.springframework.validation.Validator;

/**
 * 注入Spring依赖的校验器
 */
@Component
public class MyValidatorTwo {
    @Autowired
    private Validator validator;

    /**
     * 返回是否有校验不通过的地方
     *
     * @param user 用户实例
     * @return 是否有校验不通过的地方
     */
    public boolean validatorUser(User user) {
        BindException bindException = new BindException(user, user.getName());
        validator.validate(user, bindException);
        System.out.println(bindException.getBindingResult().getAllErrors());
        return !bindException.hasErrors();
    }
}
