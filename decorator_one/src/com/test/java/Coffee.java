package com.test.java;

/**
 * @program: java_performance_optimization
 * @Author:chenxuebing
 * @Date:2019-09-25 10:23
 * @Description:(描述)
 */

/**
 * 抛转引玉
 *  --：咖啡订单系统
 *      1.咖啡店售卖四款基础咖啡
 *        Espressio, ShortBlack, LongBlack, Decaf
 *      2.可以在四款基础咖啡的基础上加入调料，例如Milk，Soy、Chocolate  ，组成混合咖啡
 *      3.每款咖啡都共同的description属性，和getDecription()，指料明加入的调料，cost()计算咖啡所需的价格。
 */

/**
 * 咖啡的共同属性
 */
public abstract class Coffee {
    /**
     * 描述咖啡加入的调料+单品种类
     */
    private String description;

    public Coffee() {
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Coffee(String description) {
        this.description = description;
    }

    /**
     * 打印购买的咖啡信息
     */
  void getDescription(){
      System.out.println(description);
  }

    /**
     * 计算咖啡所需花费的价格
     * @return
     */
  public abstract int CoffeePrice();
}
