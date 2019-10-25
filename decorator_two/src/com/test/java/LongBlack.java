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

    /**
     * 判断当前种类的咖啡是否有加入调料，若有则加入调料的价格
     * @return
     */
    @Override
    public int CoffeePrice() {
        //单品黑咖啡的价格为20
        int cost = 20;
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
