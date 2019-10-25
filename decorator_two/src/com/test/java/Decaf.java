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
        //单品低糖咖啡的价格为30
        int cost = 30;
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
