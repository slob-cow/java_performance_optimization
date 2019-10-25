package com.test.java;

/**
 * @program: java_performance_optimization
 * @Author:chenxuebing
 * @Date:2019-09-25 15:31
 * @Description:(描述)
 */

/**
 * 单品咖啡：低糖
 */
public class Decaf extends Coffee {
    Decaf(){
       setDescription("低糖：");
       setPrice(30);
   }
    @Override
    public double coffeePrice() {
        return getPrice();
    }
}
