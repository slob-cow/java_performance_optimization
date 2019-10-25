package com.test.java;

import org.springframework.cglib.core.DebuggingClassWriter;
import org.springframework.cglib.proxy.Enhancer;

/**
 * @program: java_performance_optimization
 * @Author:chenxuebing
 * @Date:2019-09-23 11:25
 * @Description:(描述)
 */
public class Client {
    public static void main(String[] args) {
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "D:\\code");
        /**
         * 创建增强类对象
         */
        Enhancer enhancer = new Enhancer();

        /**
         * 创建需要增强的父类对象
         */
        enhancer.setSuperclass(HelloService.class);

        /**
         * 设置切入类对象
         */
        enhancer.setCallback(new CglibMethodInteceptor());

        /**
         * 生成代理对象
         */

        HelloService service = (HelloService) enhancer.create();
        service.sayHello();
        service.sayByeBye();
    }
}
