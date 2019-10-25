package com.test.java;

import org.springframework.cglib.proxy.Enhancer;

/**
 * @program: java_performance_optimization
 * @Author:chenxuebing
 * @Date:2019-09-23 14:12
 * @Description:(描述)
 */
public class Client {
    public static void main(String[] args) {
        /**
         * 创建增强类对象
         */
        Enhancer enhancer = new Enhancer();

        /**
         * 创建增强类的父类对象
         */
        enhancer.setSuperclass(DBQuery.class);

        /**
         * 创建拦截切入类
         */
        enhancer.setCallback(new DBQueryCglibMethodInterceptor());

        /**
         * 创建代理对象
         */
        DBQuery dbQueryProxy = (DBQuery) enhancer.create();
        String result = dbQueryProxy.Request();
        System.out.println(result);
    }
}
