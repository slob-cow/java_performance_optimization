package com.java.test;

/**
 * @program: java_performance_optimization
 * @Author:chenxuebing
 * @Date:2019-09-20 15:31
 * @Description:(描述)
 */

/**
 * 真实类实现了接口对公共方法做了具体的实现
 */
public class DBQuery implements DBQueryInteface{
    /**
     * 连接数据库，执行查询功能
     * @return
     */
    @Override
    public void request() {
        System.out.println("数据库连接上了，我正在执行查询功能。。。");
    }

    @Override
    public void getString() {
        System.out.println("hhh");
    }
}
