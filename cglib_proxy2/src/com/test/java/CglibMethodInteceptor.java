package com.test.java;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @program: java_performance_optimization
 * @Author:chenxuebing
 * @Date:2019-09-23 11:07
 * @Description:(描述)
 */

/**
 * cglib代理逻辑切入类
 *  ---: intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy)
 *       o: 被代理类对象
 *       method: 要拦截的被代理类的方法
 *       objects：被代理类的方法参数
 *       methodyProxy: 要触发父类的方法对象
 */
public class CglibMethodInteceptor implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("插入前置通知");
        Object object = methodProxy.invokeSuper(o, objects);
        System.out.println("插入后置通知");
        return object;
    }
}
