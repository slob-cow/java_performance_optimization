package com.test.java;

/**
 * @program: java_performance_optimization
 * @Author:chenxuebing
 * @Date:2019-09-24 9:12
 * @Description:(描述)
 */

/**
 * 享元模式：
 *  --：类似于池技术，实现对象的复用。
 *
 * 创建享元模式的三要素：
 *    一、抽象享元对象：FlyWeight
 *    二、具体享元对象：ConcreteFlyWeight
 *    三、创建享元对象的工厂: FlyWeightFactory
 * 定义享元对象要定义该对象的内部状态和外部状态
 */

/**
 * 抽象享元对象
 */
public abstract class FlyWeight {
    /**
     * 定义内部状态
     */
    private String intrinsic;

    /**
     * 定义外部状态
     */
    private String extrinsic;

    /**
     * 接受外部状态
     */
    FlyWeight(String enintrinsic){
        this.extrinsic = extrinsic;
    }

    /**
     * 定义业务操作
     */
    public abstract void operation(int extrinsic);

    public String getIntrinsic() {
        return intrinsic;
    }

    public void setIntrinsic(String intrinsic) {
        this.intrinsic = intrinsic;
    }
}
