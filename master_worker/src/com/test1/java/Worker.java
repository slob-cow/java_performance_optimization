package com.test1.java;

/**
 * @program: java_performance_optimization
 * @Author:chenxuebing
 * @Date:2019-10-17 14:04
 * @Description:(描述)
 */

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * Worker类：
 *   小任务的逻辑实现类
 */
public class Worker implements Runnable{
    /**
     * 接收master的workerQueue，用于开启线程处理多个小任务
     */
    protected Queue workerQueue;

    /**
     * 接收master的resultMap，将各个小任务的处理结果返回给Master
     */
    protected Map<String, Object> resultMap;

    /**
     * 小线程的具体逻辑，接收任务并处理任务
     * 参数： input，分解的小任务
     */
    public Object handle(Object input){
        return input;
    }

    /**
     * 从任务列表中获取任务，调用handle()方法，执行任务
     */
    @Override
    public void run() {
        while(true){
            //获取任务列表的任务
            Object input = workerQueue.poll();
            //判断任务列表是否还有任务，若没有，则终止线程。
            if(input == null){
                break;
            }
            //有任务，调用handle()方法，执行任务
            Object result = handle(input);
            //将结果放在master的resultMap中
            resultMap.put(Integer.toString(input.hashCode()),result);
        }
    }

    public Queue getWorkerQueue() {
        return workerQueue;
    }

    public void setWorkerQueue(Queue workerQueue) {
        this.workerQueue = workerQueue;
    }

    public Map<String, Object> getResultMap() {
        return resultMap;
    }

    public void setResultMap(Map<String, Object> resultMap) {
        this.resultMap = resultMap;
    }

}
