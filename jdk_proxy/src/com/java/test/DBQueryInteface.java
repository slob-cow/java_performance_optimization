package com.java.test;

/**
 * @program: java_performance_optimization
 * @Author:chenxuebing
 * @Date:2019-09-20 11:31
 * @Description:(描述)
 */

/**
 * 数据库查询的一个接口
 */
public interface DBQueryInteface {
    /**
     * 当用户去调用时通过代理去完成这个功能，
     * @return
     */
    public void request();

    public void  getString();
}
