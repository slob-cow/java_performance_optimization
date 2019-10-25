package com.test.java;

/**
 * @program: java_performance_optimization
 * @Author:chenxuebing
 * @Date:2019-09-25 14:11
 * @Description:(描述)
 */

/**
 * 将所有的调料放在超类中
 *   --：减少了组合咖啡类的定义，通过判断hasXxx（）可以在四个单品咖啡的基础上加调料，即可以通过四个单品类来得到很多的组合咖啡
 *
 *   弊端：
 *    --：1.当需要加入一种调料时，需要修改超类中的代码，这样违反了代码的开闭原则，一旦修改了代码就会有产生bug的风险。
 *        2.当用户需要加两份调料，如：加入两份牛奶时不能通过hasMilk()来计算咖啡的价格。
 *
 */
public class SaleCoffee {
    public static void main(String[] args) {
        Coffee coffee = new Decaf("无糖咖啡：");
        //组合咖啡： 无糖 + 牛奶
        coffee.setMilk(true);
        coffee.setChocolate(false);
        coffee.getDescription();
        System.out.println(coffee.CoffeePrice());
    }
}
