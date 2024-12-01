package com.shen.springaop.annoaop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

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
    @Before(value = "execution(public int com.shen.springaop.annoaop.CalculatorImpl.add(int,int))")
    public void beforeMethod() {
        logger.info("前置通知==============");
    }

    @After(value = "execution(* com.shen.springaop.annoaop.*.sub(..))")
    public void afterMethod(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        logger.info("后置通知========，方法名为:{},传参为:{}", methodName, Arrays.asList(args));
    }

    @AfterReturning(value = "execution(public int com.shen.springaop.annoaop.CalculatorImpl.*(int,int)))", returning = "result")
    public void afterReturnMethod(JoinPoint joinPoint, Object result) {
        String methodName = joinPoint.getSignature().getName();
        logger.info("返回通知========，方法名为:{},返回结果为:{}", methodName, result.toString());
    }

    @AfterThrowing(value = "execution(public int com.shen.springaop.annoaop.CalculatorImpl.mul(..))", throwing = "throwable")
    public void afterThrowingMethod(JoinPoint joinPoint, Throwable throwable) {
        String methodName = joinPoint.getSignature().getName();
        logger.info("异常通知========，方法名为:{},异常为:{}", methodName, throwable);
    }

    @Around(value = "execution(* com.shen.springaop.annoaop.CalculatorImpl.div(..))")
    public Object aroundMethod(ProceedingJoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        Object object = null;
        try {
            logger.info("环绕通知===，目标方法执行前");
            object = joinPoint.proceed();
            logger.info("环绕通知===，目标方法返回值之后");
        } catch (Throwable throwable) {
            logger.info("环绕通知===，目标方法出现异常:", throwable);
        } finally {
            logger.info("环绕通知===，目标方法执行完毕");
        }
        return object;
    }
}
