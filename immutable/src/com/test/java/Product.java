package com.test.java;

/**
 * @program: java_performance_optimization
 * @Author:chenxuebing
 * @Date:2019-10-19 11:26
 * @Description:(描述)
 */
/**
 * 不变模式的实现：
 *
 *    Product: 产品类
 *
 *    属性：
 *    no: 序列号
 *    name: 名称
 *    price：价格
 *
 *    不变模式的要求：
 *    1.类由final修饰，没有子类重载可以改变它的行为
 *    2.属性由final修饰，确保不可改
 *    3.去除setter以及所有修改属性的方法
 *    4.有一个可以创建完整对象的构造函数
 *
 * */
//1.类名由final修饰
public final class Product {
    //2.属性由private final修饰
    private final String no;
    private final String name;
    private final double price;
    //3.没有设置setter方法

    //4.可以创建完整对象的构造函数
    public Product(String no, String name, double price) {
        this.no = no;
        this.name = name;
        this.price = price;
    }
}
