package com.java.test;

/**
 * @program: java_performance_optimization
 * @Author:chenxuebing
 * @Date:2019-09-20 11:09
 * @Description:(描述)
 */

/**
 * 使用jdk动态代理模式
 * 1）jdk代理模式的特点：
 *     --：不再是一个接口对应一个多个代理类， 而是多个接口对应一个代理类
 *
 * 2）jdk动态代理的实现：
 *    --：类，Proxy: 动态的返回一个代理对象
 *        Proxy.ProxyInstance(ClassLoader classloader, class<?>[] inteface, InvocationHandler handler)
 *        ClassLoader : 被代理类的加载器
 *        calss<?>: 被代理类的全部接口
 *        InvocationHandler： 调用处理器的实现
 *
 *    --:接口，InvocationHanlder(调用处理器接口)
 *       InvocationHanlder(Object proxy, Method method, Object[] args)
 *       proxy: 被代理类对象
 *       method: 需要调用的被代理类的方法
 *       args: 参数信息
 *
 */
public class Client {
    public static void main(String[] args) {
        //通过代理工厂获取代理类
        FactoryProxy proxy = new FactoryProxy();
        //通过代理工厂在运行中生成代理对象完成指定的功能
        DBQueryInteface  result = (DBQueryInteface) proxy.bind(new DBQuery());
        result.request();
        result.getString();
    }

}
