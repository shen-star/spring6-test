package com.shen.springaop.test;

import com.shen.springaop.example.Calculator;
import com.shen.springaop.example.CalculatorImpl;
import com.shen.springaop.proxy.CalculatorStaticProxy;

/**
 * 测试静态代理
 */
public class TestStaticProxy {
    public static void main(String[] args) {
        Calculator calculator = new CalculatorImpl();
        CalculatorStaticProxy calculatorStaticProxy = new CalculatorStaticProxy(calculator);
        calculatorStaticProxy.add(1, 2);
    }
}
