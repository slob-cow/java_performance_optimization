package com.test.java;

/**
 * @program: java_performance_optimization
 * @Author:chenxuebing
 * @Date:2019-10-17 9:19
 * @Description:(描述)
 */

import javafx.concurrent.Worker;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;

 /**
 * Master-Worker工作模式：一个大任务分成几个小任务，这些小任务具有相同的实现逻辑
 *    Wroker进程：实现worker, 复写handle（），run（）方法的具体逻辑在handle()中实现，维护一个进程列表和结果集
 *    Master进程：维护一个任务列表、Worker进程列表、子结果集
 */
public class Master {
    /**
     * 任务列表
     */
    protected Queue workerQueue = new ConcurrentLinkedDeque();//并发连接队列

    /**
     * Worker进程队列
     */
    protected Map<String,Thread> threadMap = new HashMap<>();

    /**
     * 结果集队列
     */
    protected  Map<String,Object> resultMap = new ConcurrentHashMap<>();//并发的HashMap

    /**
     * 判断是否所有的子任务都结束了
     */
    public boolean isComplete(){
        //判断Worker进程中的队列是否都处于terminated（终止）状态
        for(Map.Entry<String,Thread> entry : threadMap.entrySet()) {
            if(entry.getValue().getState() != Thread.State.TERMINATED){
                return false;
            }
        }
        return true;
    }

    /**
     * Master的构造，需要一个进程逻辑和进程数量
     */
    public Master(Workers worker, int countWorker){
        //所有的子线程共同维护这workQueue、和resultMap变量
        worker.setWorkerQueue(workerQueue);
        worker.setResultMap(resultMap);
        //创建指定数量的Worker进程列表,使用Integer.toString(i指定当前线程的名字))
        for(int i = 0; i < countWorker; i++){
            threadMap.put(Integer.toString(i),new Thread(worker,Integer.toString(i)));
        }
    }

    /**
     * 添加任务
     * @return
     */
    public void submit(Object obj){
        //将任务添加到任务队列中
        workerQueue.add(obj);
    }

    /**
     * 开始运行所有的worker进程，进行处理
     * @return
     */
    public void excute(){
        for(Map.Entry<String, Thread> entery : threadMap.entrySet()){
            entery.getValue().start();
        }
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
