package com.test.java;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author yangchao
 * @date 2019/10/28.
 * @description
 */
public class ThreadPoolTest {
    public static void main(String[] args) {
        BlockQueue queue = new BlockQueue();
        //两个线程，一个线程获取队列的数据，如果队列有数据则获取数据，如果没有则等待
        /**
         *  使用线程池来创建线程对象
         */
        ExecutorService executor = Executors.newFixedThreadPool(10);
        //线程一，取数据
        executor.execute(new Runnable(){
            @Override
            public void run(){
                while(true) {
                    //获取队列的数据
                    try {
                        queue.pop();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        executor.execute(new PopThread(queue));
        //线程二，放数据
        executor.execute( new Runnable(){
            @Override
            public void run(){
                while(true) {
                   String a = "1";
                    queue.put(a);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }


}
