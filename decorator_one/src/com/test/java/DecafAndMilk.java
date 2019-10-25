package com.test.java;

/**
 * @program: java_performance_optimization
 * @Author:chenxuebing
 * @Date:2019-09-25 11:18
 * @Description:(描述)
 */

/**
 * 组合咖啡： 无糖+牛奶
 */
public class DecafAndMilk extends Coffee{
    DecafAndMilk(String description){
        super(description);
    }
    @Override
    public int CoffeePrice() {
        return 35;
    }
}
