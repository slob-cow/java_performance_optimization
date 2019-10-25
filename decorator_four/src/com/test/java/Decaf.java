package com.test.java;

/**
 * @program: java_performance_optimization
 * @Author:chenxuebing
 * @Date:2019-09-25 17:18
 * @Description:(描述)
 */

/**
 * 被装饰类：
 *  --：该类为咖啡单品类，可以为该咖啡加各种调料，然后计算咖啡的价格以及获取咖啡的种类和所加的调料
 */
public class Decaf extends Coffee{

    /**
     * 因为是单品咖啡，所以对象刚创建时价格和种类就已经确定了
     */
    Decaf(){
        setPrice(30);
        setDescription("低糖：");
    }
    @Override
    public double getCoffeePrice() {
        return this.getPrice();
    }

    @Override
    public String getCoffeeDescription() {
        return this.getDescription();
    }
}
