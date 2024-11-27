package com.shen.springaop.proxy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * 动态代理类
 */
public class ProxyFactory {
    private static final Logger logger = LoggerFactory.getLogger(ProxyFactory.class);

    //传入目标对象
    private Object target;

    public ProxyFactory(Object target) {
        this.target = target;
    }

    //返回代理对象
    public Object getProxy() {

        /**
         *Object newProxyInstance(ClassLoader loader,Class<?>[] interfaces,InvocationHandler h)
         * 获取代理对象的方法
         * 三个传参
         * loader: 类加载器
         * interfaces: 目标类对象实现的所有接口
         * h: 是一个接口，需要实现其方法。设置代理对象实现目标对象方法的过程
         * Object invoke(Object proxy, Method method, Object[] args)
         *
         * proxy 代理对象
         * method 需要重写目标对象的方法
         * args 对应目标对象方法的参数
         */
        ClassLoader classLoader = target.getClass().getClassLoader();
        Class<?>[] interfaces = target.getClass().getInterfaces();

        //匿名内部类
        InvocationHandler invocationHandler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                logger.info("[动态代理：日志]: {} 方法，参数为:{}", method.getName(), Arrays.toString(args));
                //调用目标方法
                Object result = method.invoke(target, args);
                logger.info("[动态代理：日志]: {} 方法，执行结果为:{}", method.getName(), result.toString());
                return result;
            }
        };

        return Proxy.newProxyInstance(classLoader, interfaces, invocationHandler);

    }
}
