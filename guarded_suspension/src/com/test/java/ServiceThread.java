package com.test.java;

/**
 * @program: java_performance_optimization
 * @Author:chenxuebing
 * @Date:2019-10-18 8:53
 * @Description:(描述)
 */
/**
 * 服务端线程
 *
 */
public class ServiceThread implements Runnable{
    /**
     * 内部维护一个请求队列
     */
    protected RequestQueue requestQueue = new RequestQueue();
    public ServiceThread(RequestQueue requestQueue){
        this.requestQueue = requestQueue;
    }

    /**
     * 获取请求，处理请求
     */
    @Override
    public void run() {
        while(true) {
            final Request request = requestQueue.getRequest();
            //模拟请求处理耗时，控制请求处理的时间比请求发送时间耗时长
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            //模拟请求被处理
            System.out.println(Thread.currentThread().getName()+" " + "handles:" + request);
        }
    }

}
