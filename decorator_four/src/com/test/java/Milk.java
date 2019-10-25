package com.test.java;

/**
 * @program: java_performance_optimization
 * @Author:chenxuebing
 * @Date:2019-09-25 17:27
 * @Description:(描述)
 */

/**
 * 具体的装饰者实现类
 *   --：继承装饰类
 */
public class Milk extends Decorator{
    Milk(Coffee coffee) {
        super(coffee);
        setPrice(10);
        setDescription("+牛奶");
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
