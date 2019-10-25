package com.test.java;

/**
 * @program: java_performance_optimization
 * @Author:chenxuebing
 * @Date:2019-10-17 10:23
 * @Description:(描述)
 */

import javafx.concurrent.Worker;

import java.util.Map;
import java.util.Set;

/**
 * 调度开启Master类：
 *   计算1-100的立方和
 */
public class CubicAndCalculate {
    public static void main(String[] args) {
        //创建一个Master,开启5个线程来计算立方和
        Master master = new Master(new Workers(), 5);
        //获取任务
        for(int i = 1; i <= 100; i++){
            master.submit(i);
        }
        //计算结果
        int re = 0;
        //分配任务
        master.excute();
        //master不用等待线程结束便可以取得结果
        Map resultMap = master.getResultMap();
        while(resultMap.size() > 0 || !master.isComplete()){
            Set<String> keys = resultMap.keySet();
            String key = null;
            for(String k : keys){
                key = k;
                break;

            }
            Integer i = null;
            if(key != null){
                i = (Integer) resultMap.get(key);
            }
            if(i != null){
                re += i;
            }
            if(key != null){
                resultMap.remove(key);
            }

        }
        System.out.println(re);
    }
}
