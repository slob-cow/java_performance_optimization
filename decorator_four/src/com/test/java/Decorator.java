package com.test.java;

/**
 * @program: java_performance_optimization
 * @Author:chenxuebing
 * @Date:2019-09-25 17:23
 * @Description:(描述)
 */
/**
 * 装饰类：
 *  --：接收被装饰对象，调用被装饰对象的方法
 */
public class Decorator extends Coffee{
    /**
     * 被装饰对象
     */
   private Coffee coffee = null;
    /**
     * 一初始化就有传入一个被装饰对象
     */
    Decorator(Coffee coffee){
        this.coffee = coffee;
    }

    @Override
    public double getCoffeePrice() {
        //使用被装饰者的功能
        return coffee.getCoffeePrice();
    }

    @Override
    public String getCoffeeDescription(){
        return coffee.getCoffeeDescription();
    }
}
