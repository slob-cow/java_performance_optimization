package com.java.test;

/**
 * @program: java_performance_optimization
 * @Author:chenxuebing
 * @Date:2019-09-26 9:24
 * @Description:(描述)
 */
public class Clothes {
    public static void main(String[] args) {
        Decorator decorator = new Decorator_Three(new Decorator_Second(new Decorator_First(new Person())));
        decorator.wearClothes();
    }
}
