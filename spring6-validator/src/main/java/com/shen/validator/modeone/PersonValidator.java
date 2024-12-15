package com.shen.validator.modeone;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


/**
 * 通过实现spring中的Validator类来实现数据校验
 */
public class PersonValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Person.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        //name不能为空
        ValidationUtils.rejectIfEmpty(errors, "name", "name.empty", "name is empty");
        //0<age<200
        Person person = (Person) target;
        if (0 >= person.getAge()) {
            errors.rejectValue("age", "age.error", "age <= 0");
        } else if (200 <= person.getAge()) {
            errors.rejectValue("age", "age.error", "age >= 200");
        }
    }
}
