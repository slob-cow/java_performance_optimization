package com.test.java;

/**
 * @program: java_performance_optimization
 * @Author:chenxuebing
 * @Date:2019-09-23 8:55
 * @Description:(描述)
 */
public class DBQuery implements DBQueryInterface{
    /**
     * 模拟重量级对象，对象初始化时需要进行数据库连接
     */
    DBQuery(){
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    /**
     * 数据库查询的具体逻辑实现
     * @return
     */
    @Override
    public String request() {
        return "我正在执行数据库查询操作";
    }
}
