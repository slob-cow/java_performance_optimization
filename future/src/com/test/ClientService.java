package com.test;

/**
 * @program: java_performance_optimization
 * @Author:chenxuebing
 * @Date:2019-10-16 16:18
 * @Description:(描述)
 */

import com.sun.jmx.snmp.SnmpPduTrap;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * JDK内置的Future模式的实现：
 * 构建FutureTask：
 *    FtureTask: 作为一个单独的线程运行，实现了Runable接口，有一个内部类Sync,通过内部类调用Callable接口，并维护Callable接口的返回对象。
 */
public class ClientService {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //构造FutureTask,相当于FutureData
        FutureTask future = new FutureTask(new RealData("chanta(nel香水 x 1: 购买！"));//获取虚假对象
        //返回一个线程池执行器对象
        ExecutorService executor = Executors.newFixedThreadPool(1);//创建一个线程，装配对象，执行真正的业务逻辑
        System.out.println("我真正执行其他的业务逻辑");
        //发送请求，向线程池提交任务，并返回执行结果
        //开启线程，run()方法中，执行Callable的中的call()方法，即复杂的业务逻辑
        executor.submit(future);//执行future的run方法
        //模拟执行其他的业务逻辑
        try {
            Thread.sleep(1000); //用户发送请求后可以先处理其他业务，不用等待数据的返回
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //get()方法返回call()方法的返回结果，设置一个state录ctata来记all()方法是否有调用，若没有，线程一直处于等待状态。
        System.out.println(future.get()); //处理完真正的数据获取逻辑，获取数据
    }
}
