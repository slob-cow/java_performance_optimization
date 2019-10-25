package com.test1.java;

/**
 * @program: java_performance_optimization
 * @Author:chenxuebing
 * @Date:2019-10-17 14:04
 * @Description:(描述)
 */

import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * Master类：
 *   内部维护了一个Worker进程队列、任务队列、结果集
 */
public class Master {
    /**
     * 任务队列, ConcurrentLinkedDeque: 基于链表的并发队列
     */
    protected Queue workerQueue = new ConcurrentLinkedDeque();

    /**
     * Worker进程队列
     */
    Map<String, Thread> threadMap = new HashMap<>();

    /**
     * 结果集
     */
    Map<String, Object> resultMap = new HashMap<>();

    /**
     * Master的构造，需要一个进程对象和进程数量
     */
    public Master(Worker worker, int countWorker){
        //将master的workerQueue和resultMap和Worker关联
        worker.setWorkerQueue(workerQueue);
        worker.setResultMap(resultMap);
        //根据需要的进程数量，创建进程
        for(int i = 0; i < countWorker; i++){
            //Integer.toString(i)为线程的名字
            threadMap.put(Integer.toString(i), new Thread(worker,Integer.toString(i)));
        }
    }

    /**
     * master进程提交任务
     */
    public void submit(Object input){
        workerQueue.add(input);
    }

    /**
     * master分配任务，执行任务,开启多线程
     */
    public void execute(){
        for(Map.Entry<String,Thread> entry : threadMap.entrySet()){
            entry.getValue().start();

        }
    }

    /**
     * 判断是否所有的子任务都结束了
     */
    public boolean isComplete(){
        //判断worker进程的状态是否都等于终止状态
        for(Map.Entry<String,Thread> entry : threadMap.entrySet()){
            if(entry.getValue().getState() != Thread.State.TERMINATED){
                return false;
            }
        }
        return true;
    }

    public Queue getWorkerQueue() {
        return workerQueue;
    }

    public void setWorkerQueue(Queue workerQueue) {
        this.workerQueue = workerQueue;
    }

    public Map<String, Thread> getThreadMap() {
        return threadMap;
    }

    public void setThreadMap(Map<String, Thread> threadMap) {
        this.threadMap = threadMap;
    }

    public Map<String, Object> getResultMap() {
        return resultMap;
    }

    public void setResultMap(Map<String, Object> resultMap) {
        this.resultMap = resultMap;
    }
}
