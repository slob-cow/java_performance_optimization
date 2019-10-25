package com.test.java;

/**
 * @program: java_performance_optimization
 * @Author:chenxuebing
 * @Date:2019-09-25 11:10
 * @Description:(描述)
 */

/**
 * 浓缩咖啡
 */
public class ShortBlack extends Coffee{
    ShortBlack(String description){
        super(description);
    }
    @Override
    public int CoffeePrice() {
        return 15;
    }
}
