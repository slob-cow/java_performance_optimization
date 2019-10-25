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
        //单品浓缩咖啡的价格为15
        int cost = 15;
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
