package com.test.java;

/**
 * @program: java_performance_optimization
 * @Author:chenxuebing
 * @Date:2019-09-23 9:21
 * @Description:(描述)
 */
public class Client {
    public static void main(String[] args) {
        //加载数据库查询代理工厂
        DBQueryJdkProxy dbQueryJdkProxy = new DBQueryJdkProxy();
        //给指定的对象创建代理工厂
        DBQueryInterface proxy = (DBQueryInterface) dbQueryJdkProxy.bind(new DBQuery());
        proxy.request();
    }
}
