package com.test.java;

import com.sun.org.apache.bcel.internal.generic.RETURN;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @program: java_performance_optimization
 * @Author:chenxuebing
 * @Date:2019-09-23 13:56
 * @Description:(描述)
 */

/**
 * 实现代理的逻辑
 * 步骤：
 *   --： 1、实现MethodInterceptor拦截器
 *        o: 被代理对象
 *        method: 被代理对象的方法
 *        objects: 被代理对象的方法参数
 *        methodProxy: 触发父类方法的对象
 */
public class DBQueryCglibMethodInterceptor implements MethodInterceptor {
    DBQuery dbQuery = null;
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
           if(dbQuery == null){
               dbQuery = new DBQuery();
           }
           return dbQuery.Request();
    }
}
