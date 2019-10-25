package com.java.test;

/**
 * @program: java_performance_optimization
 * @Author:chenxuebing
 * @Date:2019-09-26 9:18
 * @Description:(描述)
 */
public abstract class Decorator implements Humman {
    Humman humman = null;
    Decorator(Humman humman){
        this.humman = humman;
    }
    @Override
    public void wearClothes() {
        humman.wearClothes();
    }
}
