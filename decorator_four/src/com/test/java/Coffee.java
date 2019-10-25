package com.test.java;

/**
 * @program: java_performance_optimization
 * @Author:chenxuebing
 * @Date:2019-09-25 17:06
 * @Description:(描述)
 */

/**
 * 实现装饰者模式的逻辑：
 *       1.公共接口类：
 *       --:需要一个公共接口类
 *         该接口定义了被装饰类的主要逻辑方法，被装饰者和装饰者分别去实现或继承这个接口
 *       2.被装饰类：
 *         被装饰者实现公共接口类，并对接口方法做具体实现
 *       3.装饰类：
 *        装饰类接收被装饰类对象，调用被装饰类的方法
 *       4.具体装饰类
 *         继承装饰类，做具体的装饰逻辑实现
 */

/**
 * 公共接口类:
 *   --: 定义需要装饰的接口方法以及公共的对象属性
 */
public abstract class Coffee {
    private String description;

    private double price;

    /**
     * 获取咖啡的价格
     * @return
     */
    public abstract double getCoffeePrice();

    public abstract String getCoffeeDescription();

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
