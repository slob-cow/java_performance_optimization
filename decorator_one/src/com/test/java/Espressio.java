package com.test.java;

/**
 * @program: java_performance_optimization
 * @Author:chenxuebing
 * @Date:2019-09-25 10:53
 * @Description:(描述)
 */

/**
 * 浓咖啡
 */
public class Espressio extends Coffee {
    Espressio(String description){
        super(description);
    }
    @Override
    public int CoffeePrice() {
        return 10;
    }
}
