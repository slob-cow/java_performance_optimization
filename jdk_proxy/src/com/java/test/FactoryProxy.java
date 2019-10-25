package com.java.test;

/**
 * @program: java_performance_optimization
 * @Author:chenxuebing
 * @Date:2019-09-20 15:39
 * @Description:(描述)
 */


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 工厂代理类，该类能够为多个接口提供代理对象
 *  --： 该类需要实现一个InvocationHandler接口，复写invoke（）方法，再通过调用Proxy.ProxyInstance()来获取生成的代理对象
 */
public class FactoryProxy implements InvocationHandler {
    /**
     * 代类理接收一个真实类，调用真实类的实现逻辑去完成用户指定的功能
     */
    private Object target;

    //代理公司开始接收生成代理订单，为真实类target生成代理
    public Object bind(Object target){
        this.target = target;
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //使用代理类可以增强原有类的功能
        System.out.println("事物开始");
        Object result = method.invoke(target, args);
        System.out.println("事物结束");
        return result;
    }
}
/**
 *  jdk实现动态代理的思想：
 *  通过newProxyInstance(真实对象的类加载器， 真实对象的所接口， 调用控制器)来生成一个代理类，使用代理类和真实类公共接口来接收代理类
 *  调用公共接口的方法来实现功能
 *  在调用处理器的invoke()方法来实现代理类的逻辑
 */
