package com.test.java;

/**
 * @program: java_performance_optimization
 * @Author:chenxuebing
 * @Date:2019-09-25 15:33
 * @Description:(描述)
 */
public class Decorator extends Coffee {
    private Coffee coffee;
    Decorator(Coffee coffee){
        this.coffee = coffee;
        setDescription(coffee.getDescription());
    }

    public Decorator() {
    }

    @Override
    public double coffeePrice() {
        return coffee.coffeePrice();
    }
}
