package com.test.java;

/**
 * @program: java_performance_optimization
 * @Author:chenxuebing
 * @Date:2019-09-24 11:08
 * @Description:(描述)
 */

/**
 * 围棋游戏
 * --： 围棋分白子和黑子，用户在玩围棋时会用到多个黑子和白子
 */
public class Client {
    /**
     * 模拟下棋操作
     *  --：此时，出现了一个问题：
     *      每当用户出一个棋子就会重行创建一个棋对象，如果很多用户在下棋，那么，服务器就会有很对棋对象，占用服务器的内存
     *
     *  --：发现规律，用户操作棋子，棋子的颜色（黑色和白色）不会变化，变棋子的位置发生化。
     *      解决问题：
     *      所有的用户使用同一个棋子对象
     * @param args
     */
    public static void main(String[] args) {
  /*      //第一步黑棋落子
        Chess chess1 = new Chess("黑色", 1, 2);
        chess1.display();
        //第二步，白棋落子
        Chess chess2 = new Chess("白色", 2, 6);
        chess2.display();
        //第一步黑棋落子
        Chess chess3 = new Chess("黑色", 1, 2);
        chess3.display();
        //第二步，白棋落子
        Chess chess4 = new Chess("白色", 2, 6);
        chess4.display();*/
    }
}
