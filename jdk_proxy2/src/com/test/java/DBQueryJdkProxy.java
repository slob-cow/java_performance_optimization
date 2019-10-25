package com.test.java;

/**
 * @program: java_performance_optimization
 * @Author:chenxuebing
 * @Date:2019-09-23 9:00
 * @Description:(描述)
 */

import java.lang.annotation.Target;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 使用动态代理创建数据库查询的代理对象
 * 1、实现InvocationHandler接口
 * 2、调用Proxy.newInstance()动态的创建代理对象
 */
public class DBQueryJdkProxy implements InvocationHandler {
    Object target;
    /**
     * 获取代理对象
     */
    public Object bind(Object target){//target是真实类对象，给给定的真实类对象创建一个代理，由代理去完成真实类的工作
        this.target = target;
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }

    /**
     * 增强原有类的功能
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("事物开始");
        System.out.println(method.invoke(target, args));
        System.out.println("事物结束");
        return null;
    }
}
