package com.test.java;

/**
 * @program: java_performance_optimization
 * @Author:chenxuebing
 * @Date:2019-09-24 11:10
 * @Description:(描述)
 */

/**
 * 围棋
 *  --： 棋子的属性
 *       颜色：黑色/白色，是不变的。
 *       坐标：x,y ,变化的。
 */
public abstract class Chess {
    //棋子的颜色为内部状态
    private String color;
    /**
     * 享元模式，将可变的东西转为外部状态。
     */
    //private int x;
    //private int y;

    public abstract String getColor();

    //Coordinates coord 为外部状态，通过外部注入的方式生成
    public void display(Coordinates coord){
        System.out.println("棋子的颜色："+ this.getColor() +"-->棋子所在的位置"+coord.getX()+","+coord.getY());
    }
}
