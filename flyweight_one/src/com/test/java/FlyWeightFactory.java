package com.test.java;

/**
 * @program: java_performance_optimization
 * @Author:chenxuebing
 * @Date:2019-09-24 10:11
 * @Description:(描述)
 */

import java.util.HashMap;
import java.util.Map;

/**
 * 享元模式工厂
 */
public class FlyWeightFactory {

    /**
     *  创建一个hashMap集合，相当于用于存放对象的池。
     */
    public static Map<String, ConcreteFlyWeight> pool = new HashMap<>();

    /**
     * 通过工厂创建享元对象前判断该对象是否存在池中，如果存在，则返回池中对象。如若不存在，重新创建一个实例，并将该实例存放在池中。
     *  --: 根据外部条件extrinsic来判断对象是否存在
     */

    public static FlyWeight getFlyWeight(String extrinsic){
        //如果外部条件存在，则从池中取出数据
        if(pool.containsKey(extrinsic)){
            System.out.println("已有："+extrinsic+ "--->"+"直接从池中取出");
            return pool.get(extrinsic);
        } else{
            //如果外部条件不存在，则重新创建一个实例,并将实例放入池中。
            ConcreteFlyWeight concreteFlyWeight = new ConcreteFlyWeight(extrinsic);
            pool.put(extrinsic, concreteFlyWeight);
            System.out.println("创建："+extrinsic+ "--->"+"并从池中取出");
            return concreteFlyWeight;
        }
    }
}
