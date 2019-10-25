package com.test1.java;

/**
 * @program: java_performance_optimization
 * @Author:chenxuebing
 * @Date:2019-10-18 11:27
 * @Description:(描述)
 */

/**
 * 服务进程：
 *   属性：RequestQueue,获取请求的队列
 */
public class ServiceThread extends Thread{
    /**
     * 请求队列
     */
    protected RequestQueue requestQueue;

    public ServiceThread(RequestQueue requestQueue, String name) {
        super(name);
        this.requestQueue = requestQueue;
    }

    @Override
    public void run(){
       while(true){
           //从队列中获取请求
           Request request = requestQueue.getRequest();
           //进行真正的数据处理并返回
           FutureData future = (FutureData) request.getResponse();
           RealData realData = new RealData(request);
           future.setRealData(realData);
           //模拟用户对请求进行了处理
           System.out.println(Thread.currentThread().getName()+" handle"+request);

       }
    }

}
