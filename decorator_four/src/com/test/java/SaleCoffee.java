package com.test.java;

/**
 * @program: java_performance_optimization
 * @Author:chenxuebing
 * @Date:2019-09-25 18:58
 * @Description:(描述)
 */
public class SaleCoffee {
    public static void main(String[] args) {
        Decorator decorator = new Decorator(new Milk(new Milk(new Decaf())));
        System.out.println(decorator.getCoffeeDescription());
        System.out.println(decorator.getCoffeePrice());
    }
}
