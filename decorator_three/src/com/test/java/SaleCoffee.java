package com.test.java;

/**
 * @program: java_performance_optimization
 * @Author:chenxuebing
 * @Date:2019-09-25 15:39
 * @Description:(描述)
 */
public class SaleCoffee {
    public static void main(String[] args) {
        Decaf decaf = new Decaf();
        Decorator decorator = new Decorator(new Soy(new Milk(decaf)));
        System.out.println(decorator.getDescription());
        System.out.println(decorator.coffeePrice());
    }
}
