package com.test.java;

/**
 * @program: java_performance_optimization
 * @Author:chenxuebing
 * @Date:2019-09-25 15:32
 * @Description:(描述)
 */
public class Milk extends Decorator {
    Milk(Coffee coffee) {
        super(coffee);
        setDescription(coffee.getDescription()+"+牛奶");
        setPrice(10);
    }

    @Override
    public double coffeePrice() {
        return super.coffeePrice()+this.getPrice();
    }
}
