package com.test;

/**
 * @program: java_performance_optimization
 * @Author:chenxuebing
 * @Date:2019-10-16 19:27
 * @Description:(描述)
 */

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * 使用JDK自带的模式实现程序的并发执行
 * 模拟淘宝下单：
 *     购买香水，用户购买商品后返回一个商品订单，并没有马上返回商品，用户需等待物流才能获得商品
 *     在等待物流派送的这段时间用户可以做其他事情，当货物到达再取货。当用户想要取货时，可以通过物流信息
 *     来监控货物是否到达，若物流状态为未到达，用户不可取货，只能等待。
 */
public class JDK_ClientService {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //创建一个FutureTask对象，相当于上文FutureData，该对象是一个线程类
        FutureTask future = new FutureTask(new RealData("chanta(nel香水 x 1: 购买！"));
        //创将线程池执行器,返回一个ThreadPool对象
        ExecutorService executor = Executors.newFixedThreadPool(1);
        //开启线程，发送请求，执行future线程的run()方法，执行请求的具体逻辑
        executor.submit(future);
        System.out.println("我要去执行其他业务了");
        //模拟程序执行其它逻辑
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //得到请求的真实返回数据,get方法会判断监控call()的状态，当call()的状态未执行或未执行完毕，线程进入等待状态。
        System.out.println(future.get());
    }

}
