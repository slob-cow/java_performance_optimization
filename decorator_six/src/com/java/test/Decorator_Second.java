package com.java.test;

/**
 * @program: java_performance_optimization
 * @Author:chenxuebing
 * @Date:2019-09-26 9:23
 * @Description:(描述)
 */
public class Decorator_Second extends Decorator {
    Decorator_Second(Humman humman) {
        super(humman);
    }
    @Override
    public void wearClothes(){
        humman.wearClothes();
        System.out.println("找到啦！");
    }
}
