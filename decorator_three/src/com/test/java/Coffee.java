package com.test.java;

/**
 * @program: java_performance_optimization
 * @Author:chenxuebing
 * @Date:2019-09-25 15:26
 * @Description:(描述)
 */

/**
 * 使用装饰者模式来实现coffee的点单系统
 */
public abstract class Coffee {
    /**
     * 描述单品的类型以及加入的调料种类
     */
    private String description;

    /**
     * 价格
     */
    private double price;

    /**
     * 计算咖啡所花费的价格
     */
    public abstract double coffeePrice();

    /**
     * 获取单品类型以及加入的调料
     * @return
     */
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
