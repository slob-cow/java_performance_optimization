package com.test.java;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

/**
 * @program: java_performance_optimization
 * @Author:chenxuebing
 * @Date:2019-10-17 9:52
 * @Description:(描述)
 */
public class Workers implements Runnable{
    /**
     * 任务列表
     */
    protected Queue<Object> workerQueue;

    /**
     * 结果集
     */
    protected Map<String,Object> resultMap = new HashMap<>();

    /**
     * 子任务的具体逻辑由handle实现，在run()方法中调用handle()
     * @param input
     * @return
     */
    public Object handle(Object input){
      int i = (Integer)input;
      return i * i * i;
    }

    @Override
    public void run() {
        while(true){
            //从任务队列中获取子任务
            Object input = workerQueue.poll();
            if(input == null) {
                break;
            }
            //执行子任务的业务逻辑
            Object re = handle(input);
            //将处理的结果写入结果集
            resultMap.put(Integer.toString(input.hashCode()), re);
        }
    }

    public Queue<Object> getWorkerQueue() {
        return workerQueue;
    }

    public void setWorkerQueue(Queue<Object> workerQueue) {
        this.workerQueue = workerQueue;
    }

    public Map<String, Object> getResultMap() {
        return resultMap;
    }

    public void setResultMap(Map<String, Object> resultMap) {
        this.resultMap = resultMap;
    }

}
