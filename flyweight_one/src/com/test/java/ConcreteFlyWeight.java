package com.test.java;

/**
 * @program: java_performance_optimization
 * @Author:chenxuebing
 * @Date:2019-09-24 9:57
 * @Description:(描述)
 */

/**
 * 具体享元对象
 *  --: 实现抽象享元对象
 */
public class ConcreteFlyWeight extends FlyWeight{
    /**
     * 接受外部状态
     * @param extrinsic
     */
    ConcreteFlyWeight(String extrinsic){
        super(extrinsic);
    }

    /**
     * 根据外部状态进行操作
     * @param extrinsic
     */
    @Override
    public void operation(int extrinsic) {
        System.out.println("具体享元对象：flyweight"+ extrinsic);
    }
}
