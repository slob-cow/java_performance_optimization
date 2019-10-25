package com.test.java;

/**
 * @program: java_performance_optimization
 * @Author:chenxuebing
 * @Date:2019-09-25 11:13
 * @Description:(描述)
 */

/**
 * 低糖咖啡
 */
public class Decaf extends Coffee {
    Decaf(String description){
        super(description);
    }
    @Override
    public int CoffeePrice() {
        return 30;
    }
}
