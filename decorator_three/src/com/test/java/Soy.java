package com.test.java;

/**
 * @program: java_performance_optimization
 * @Author:chenxuebing
 * @Date:2019-09-25 16:47
 * @Description:(描述)
 */

/**
 * 具体装饰类
 */
public class Soy extends Decorator {
    /**
     * 创建对象的时候就传入被装饰类
     */
   Soy(Coffee coffee){
       super(coffee);
       setDescription(coffee.getDescription()+"+豆浆");
       setPrice(2);
   }
   @Override
    public double coffeePrice(){
       return super.coffeePrice()+this.getPrice();
   }
}
