package com.test.java;

/**
 * @program: java_performance_optimization
 * @Author:chenxuebing
 * @Date:2019-09-25 13:30
 * @Description:(描述)
 */


import com.sun.xml.internal.ws.util.StringUtils;

/**
 * 构建第二种形式的咖啡超类
 *   --: 一开始就给定了咖啡的调料
 */
public abstract class Coffee {
    /**
     * 描述咖啡的种类和调料
     */
    private String description;

    /**
     * 将咖啡的调料内置在超类中
     */
    private boolean milk;

    private boolean soy;

    private boolean chocolate;

    public Coffee(String description) {
        this.description = description;
    }

    public Coffee() {
    }


    /**
     * 判断是否加了牛奶
     * @return
     */
    public Boolean hashMilk(){
       return milk;
    }

    /**
     * 判断是否加了豆浆
     * @return
     */
    public Boolean hashSoy(){
       return soy;
    }

    /**
     * 判断是否加了巧克力
     * @return
     */
    public Boolean hashChocolate(){
        return chocolate;
    }

    /**
     * 根据咖啡的种类和调料计算咖啡的价格
     */
    public abstract int CoffeePrice();

    public void getDescription() {
        System.out.println(description);
    }

    public void setDescription(String description) {
        this.description += description;
    }

    public void setMilk(boolean milk) {
        this.milk = milk;
        if(milk == true) {
            setDescription("+牛奶");
        }
    }

    public void setSoy(boolean soy){
        this.soy = soy;
        if(soy == true){
            setDescription("+豆浆");
        }
    }

    public void setChocolate(boolean chocolate) {
        this.chocolate = chocolate;
        if(chocolate == true) {
            setDescription("+chocolate");
        }
    }
}
