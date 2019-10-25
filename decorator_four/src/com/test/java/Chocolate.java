package com.test.java;

/**
 * @program: java_performance_optimization
 * @Author:chenxuebing
 * @Date:2019-09-25 18:55
 * @Description:(描述)
 */
public class Chocolate extends Decorator {
    Chocolate(Coffee coffee) {
        super(coffee);
        setPrice(15);
        setDescription("+chocolate");
    }
    @Override
    public double getCoffeePrice() {
        //使用被装饰者的功能
        return super.getCoffeePrice()+this.getPrice();
    }

    @Override
    public String getCoffeeDescription(){
        return super.getCoffeeDescription()+this.getDescription();
    }

}
