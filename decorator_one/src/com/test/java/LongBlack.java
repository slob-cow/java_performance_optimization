package com.test.java;

/**
 * @program: java_performance_optimization
 * @Author:chenxuebing
 * @Date:2019-09-25 11:11
 * @Description:(描述)
 */

/**
 * 黑咖啡
 */
public class LongBlack extends Coffee{
    LongBlack(String description){
        super(description);
    }
    @Override
    public int CoffeePrice() {
        return 20;
    }
}
