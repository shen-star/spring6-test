package com.shen.springaop.test;

import com.shen.springaop.example.Calculator;
import com.shen.springaop.example.CalculatorImpl;
import com.shen.springaop.proxy.ProxyFactory;

/**
 * 测试动态代理类
 */
public class TestProxyFactory {
    public static void main(String[] args) {
        Calculator calculator = new CalculatorImpl();
        ProxyFactory proxyFactory = new ProxyFactory(calculator);
        Calculator calculatorProxy = (Calculator) proxyFactory.getProxy();
        calculatorProxy.add(1, 2);
        calculatorProxy.mul(2, 5);
    }
}
