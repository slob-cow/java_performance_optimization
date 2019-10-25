package com.test.java;

/**
 * @program: java_performance_optimization
 * @Author:chenxuebing
 * @Date:2019-09-23 11:01
 * @Description:(描述)
 */

/**
 * 使用cglib实现动态代理，不用创建接口
 */
public class HelloService {
    HelloService(){
        System.out.println("HelloServie构造器");
    }

    public final String sayOthers(String name){
        System.out.println("HelloService: sayOthers" +name);
        return null;
    }

    public void sayHello(){
        System.out.println("HelloService: sayHello");
    }
}
