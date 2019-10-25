package com.test.java;

/**
 * @program: java_performance_optimization
 * @Author:chenxuebing
 * @Date:2019-09-24 13:40
 * @Description:(描述)
 */

/**
 * 通过工厂来创建棋子
 *
 */
public class Client2 {
    public static void main(String[] args) {
        //通过工厂创建一个黑棋对象
        Chess blackChess1 = ChessFactory.getChess("b");
        blackChess1.display(new Coordinates(1,3));
        //从池中取出黑棋对象
        Chess blackChess2 = ChessFactory.getChess("b");
        blackChess2.display(new Coordinates(3,6));
        System.out.println(blackChess1 == blackChess2);

        Chess whiteChess1 = ChessFactory.getChess("w");
        whiteChess1.display(new Coordinates(1,1));
        Chess whiteChess2 = ChessFactory.getChess("w");
        whiteChess2.display(new Coordinates(2, 2));
        System.out.println(whiteChess1 == whiteChess2);

    }
}
