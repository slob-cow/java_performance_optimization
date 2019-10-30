package com.test.java;

/**
 * @author yangchao
 * @date 2019/10/30.
 * @description
 */

import java.util.concurrent.ArrayBlockingQueue;

/**
 * 消费者线程，维护了一个消费队列
 */
public class Consumer extends Thread{
    protected  ArrayBlockingQueue queue;

    public Consumer(ArrayBlockingQueue queue,String name) {
        super(name);
        this.queue = queue;
    }

    @Override
    public void run() {
        //模拟消费者线程进行消费
        try {
            System.out.println(Thread.currentThread().getName()+" 要开始消费了");
            queue.take();
            System.out.println(Thread.currentThread().getName()+" 消费了一件商品");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
