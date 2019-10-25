package com.test.java;

/**
 * @program: java_performance_optimization
 * @Author:chenxuebing
 * @Date:2019-09-24 11:45
 * @Description:(描述)
 */

import java.util.HashMap;
import java.util.Map;

/**
 * 创建棋子的工厂,工厂生产的产品不重复
 *   ---：1. 通过工厂，可以创建一批同类对象。
 *        2. 通过过池（集合），可以复用对象。
 */
public class ChessFactory {
    /**
     * 将棋子存放在一个集合中，保证生产的产品不重复
     */
    private static Map<String, Chess> pool = new HashMap<>();

    /**
     *  接单时先根据产品标识，判断产品是否重复
     */
    public static Chess getChess(String color){
        Chess chess = null;
        if(pool.containsKey(color)){
            return pool.get(color);
        }
        //如果池中没有所要对象则重新创建对象，并放入池中
        if(color == "b"){
            chess = new BlackChess();
            pool.put(color, chess);
            return chess;
        }
        if(color == "w"){
            chess = new WhiteChess();
            pool.put(color, chess);
            return chess;
        }
        return chess;
    }
}
