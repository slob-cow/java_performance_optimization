package com.test1.java;

/**
 * @program: java_performance_optimization
 * @Author:chenxuebing
 * @Date:2019-10-18 11:28
 * @Description:(描述)
 */

/**
 * 客户线程
 *    属性： RequestQueue,请求队列,将请求放入队列中
 */
public class ClientThread extends Thread{
    /**
     * 请求队列
     */
    protected RequestQueue requestQueue;

    public ClientThread(RequestQueue requestQueue, String name) {
        super(name);
        this.requestQueue = requestQueue;
    }
    @Override
    public void run(){
        for(int i = 0; i < 10; i++) {
            //构造request,模拟发送的请求
            Request request = new Request("[RequestId:" + i + " Thread_Name:" + Thread.currentThread().getName());
            //将请求放入请求队列
            requestQueue.addRequest(request);
            //用户发送完请求变可以获得一个轻量级的响应对象
            request.setResponse(new FutureData());
            //模拟用户不用等待真实数据的返回，处理其他业务逻辑
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //获取真实的响应数据
            System.out.println(request.getResponse().getResult());
            System.out.println(Thread.currentThread().getName()+" "+request);
            //模拟用户发送请求的时间比服务处理请求的快
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("ClientThread name is "+Thread.currentThread().getName());
        }
        System.out.println(Thread.currentThread().getName()+" is end!");
    }
}
