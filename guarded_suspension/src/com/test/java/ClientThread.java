package com.test.java;

/**
 * @program: java_performance_optimization
 * @Author:chenxuebing
 * @Date:2019-10-18 8:53
 * @Description:(描述)
 */

import java.util.LinkedList;

/**
 * 客户线程
 */
public class ClientThread implements Runnable{
    /**
     * 内部维护一个请求队列
     */
    protected RequestQueue requestQueue = new RequestQueue();
    public ClientThread(RequestQueue requestQueue){
        this.requestQueue = requestQueue;
    }

    @Override
    public void run() {
        //构造客户请求
        for(int i = 0; i < 10; i++){
            Request request = new Request("RequestId:"+ i + " Thread_Name:" + Thread.currentThread().getName());
            System.out.println(Thread.currentThread().getName()+" "+"request:"+request);
            //将请求放入请求队列
            requestQueue.addRequest(request);
            //控制客户端提交请求的速度，快于服务端处理请求的速度
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("ClientThread Name is"+ Thread.currentThread().getName()+" "+"request:"+request);
        }
        System.out.println(Thread.currentThread().getName()+" end");
    }
}
