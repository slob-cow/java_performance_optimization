package com.test.java;

/**
 * @program: java_performance_optimization
 * @Author:chenxuebing
 * @Date:2019-09-25 11:14
 * @Description:(描述)
 */

/**
 * 售卖咖啡
 *  使用传统方式来构建售卖咖啡的类：
 *    --: 所有的混合咖啡都实现了超类Coffee
 *        此时，出现了一个问题
 *        ---》1.因为调料的种类很多，调料与调料之间的组合方式也很多，这时咖啡类的数量就会增多。
 *            2.因为所有的混合咖啡都是在单品咖啡的基础上构建的，当单品咖啡的价格发生了调整，所有
 *               与单品咖啡相关的混合咖啡的价格都要进行调整。
        */
public class SaleCoffee {
    public static void main(String[] args) {
        Coffee coffee = new Decaf("无糖咖啡");
        //打印咖啡的种类和价格
        coffee.getDescription();
        System.out.println(coffee.CoffeePrice());

        //无糖+牛奶的咖啡
        Coffee coffee1 = new DecafAndMilk("无糖咖啡：+牛奶");
        coffee1.getDescription();
        System.out.println(coffee1.CoffeePrice());
    }
}
