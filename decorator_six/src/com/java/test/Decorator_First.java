package com.java.test;

/**
 * @program: java_performance_optimization
 * @Author:chenxuebing
 * @Date:2019-09-26 9:20
 * @Description:(描述)
 */

/**
 * 第一层修饰
 */
public class Decorator_First extends Decorator{
    Decorator_First(Humman humman) {
        super(humman);
    }
    @Override
    public void wearClothes(){
        humman.wearClothes();
        System.out.println("去柜子找找");
    }
}
