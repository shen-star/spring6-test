package com.shen.springaop.annoaop;

import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 切面类
 */
@Aspect //声明为切面类
@Component //ioc容器管理
public class LogAspect {
    private static final Logger logger = LoggerFactory.getLogger(LogAspect.class);
    //通知类型: 前置，返回，异常，后置，环绕
    //前置 @Before()
    //返回 @AfterReturning
    //异常 @AfterThrowing
    //后置 @After()
    //环绕 @Around()

    //设置切入点与通知类型
    //切入点表达式: execution(访问修饰符 增强方法返回类型 增强方法所在类的全类名.方法名称(参数列表))
    //前置  @Before(value = "切入点表达式配置切入点")
    @Before(value = "execution(public int com.shen.springaop.annoaop.CalculatorImpl.add(..))")
    public void beforeMethod() {
        logger.info("方法执行前==============");
    }
}
