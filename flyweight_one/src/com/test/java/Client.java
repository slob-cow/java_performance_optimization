package com.test.java;

/**
 * @program: java_performance_optimization
 * @Author:chenxuebing
 * @Date:2019-09-24 10:26
 * @Description:(描述)
 */

/**
 * 通过工厂，创建享元对象
 */
public class Client {
    public static void main(String[] args) {
        int extrinsic = 22;

        FlyWeight flyweightX = FlyWeightFactory.getFlyWeight("X");
        flyweightX.operation(++ extrinsic);
        FlyWeight flyweightY = FlyWeightFactory.getFlyWeight("Y");
        flyweightX.operation(++ extrinsic);
        FlyWeight flyweightZ = FlyWeightFactory.getFlyWeight("Z");
        flyweightX.operation(++ extrinsic);
        FlyWeight flyweightReX = FlyWeightFactory.getFlyWeight("X");
        flyweightX.operation(++ extrinsic);

    }

}
