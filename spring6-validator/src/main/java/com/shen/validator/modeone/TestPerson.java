package com.shen.validator.modeone;

import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;

/**
 * 测试数据校验
 */
public class TestPerson {
    public static void main(String[] args) {
        //创建person对象
        Person person = new Person();
        person.setName("alex");
        person.setAge(20);
        //创建person对应databinder
        DataBinder dataBinder = new DataBinder(person);
        //设置校验器
        dataBinder.setValidator(new PersonValidator());
        //调用方法执行校验器
        dataBinder.validate();
        //输出校验结果
        BindingResult bindingResult = dataBinder.getBindingResult();
        System.out.println(bindingResult.getAllErrors());
    }
}
