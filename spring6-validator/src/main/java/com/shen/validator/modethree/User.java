package com.shen.validator.modethree;

import jakarta.validation.constraints.*;

/**
 * 用户信息类
 *
 * @NotNull 限制必须不为null
 * @NotEmpty 只作用于字符串类型，字符串不为空，并且长度不为0
 * @NotBlank 只作用于字符串类型，字符串不为空，并且trim()后不为空串
 * @DecimalMax(value) 限制必须为一个不大于指定值的数字
 * @DecimalMin(value) 限制必须为一个不小于指定值的数字
 * @Max(value) 限制必须为一个不大于指定值的数字
 * @Min(value) 限制必须为一个不小于指定值的数字
 * @Pattern(value) 限制必须符合指定的正则表达式
 * @Size(max,min) 限制字符长度必须在min到max之间
 * @Email 验证注解的元素值是Email，也可以通过正则表达式和flag指定自定义的email格式
 */
public class User {
    @NotNull
    private
    String name;
    @Max(200)
    @Min(1)
    private int age;

    @Pattern(regexp = "^1(3|4|5|7|8)\\d{9}$", message = "手机号码格式错误")
    @NotBlank(message = "手机号码不能为空")
    private String phone;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
