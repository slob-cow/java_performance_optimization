package com.test1.java;

/**
 * @program: java_performance_optimization
 * @Author:chenxuebing
 * @Date:2019-10-17 14:04
 * @Description:(描述)
 */

import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * 使用Master-Worker模式实现 ：
 *    计算 1~100的立方和（ 1^3 + 2^3 + ... + 100^3 ）
 *    1.将计算任务分解为100个小任务，每个子任务计算单独的立方和，最后将计算结果返回给master
 */
public class CubicAndCalculate {
    public static void main(String[] args) {
        //创建Master对象，开启五个线程对任务进行处理
        Master master = new Master(new PlushWorker(), 5);
        //将大任务分解成100个小任务
        for(int i = 1; i <= 100; i++){
            master.submit(i);
        }
        //开启多线程，并发的处理多个小任务
        master.execute();
        //master可以不用等全部的任务执行完便可以获取任务的执行结果
        Map<String, Object> resultMap = master.getResultMap();
        Integer re = 0;
        //加入两个判断是因为，每取出一个resultMap中的数据，都要对该数据删除，若消费resultMap的速度比生成的快，可通过判断任务线程是否执行完毕来控制数据的获取
        while(resultMap.size() > 0 || !master.isComplete()){
            //获取map的所有键
            Set<String> set = resultMap.keySet();
            String key = null;
            for(String k : set){
                key = k;
                break;
            }
            Integer i = null;
            //判断map中是否有数据,若key值为null,就不进行获取值操作
            if(key != null){
                i = (Integer) resultMap.get(key);
            }
            //如果key存在，i !=null，则对返回的部分的任务的立方和进行累加，并移除resultMap中对应的项
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
