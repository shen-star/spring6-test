package com.shen.springaop.proxy;

import com.shen.springaop.example.Calculator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 计算器静态代理类
 */
public class CalculatorStaticProxy implements Calculator {
    private static final Logger logger = LoggerFactory.getLogger(CalculatorStaticProxy.class);

    //被代理的目标传进来
    private Calculator calculator;

    public CalculatorStaticProxy(Calculator calculator) {
        this.calculator = calculator;
    }

    @Override
    public int add(int i, int j) {
        //输出日志
        logger.info("[日志]: add方法开始了，参数为[{}]和[{}]", i, j);
        int addResult = calculator.add(i, j);
        logger.info("[日志]: add方法结束了，结果为:[{}]", addResult);
        return addResult;
    }

    @Override
    public int sub(int i, int j) {
        return 0;
    }

    @Override
    public int mul(int i, int j) {
        return 0;
    }

    @Override
    public int div(int i, int j) {
        return 0;
    }
}
