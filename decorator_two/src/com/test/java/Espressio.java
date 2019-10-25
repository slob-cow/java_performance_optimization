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
        //单品浓咖啡的价格为10
        int cost = 10;
        if(this.hashMilk()){
            cost = cost + 5;
        }
        if(this.hashChocolate()){
            cost = cost + 10;
        }
        if(this.hashSoy()){
            cost = cost + 2;
        }
        return cost;
    }
}
