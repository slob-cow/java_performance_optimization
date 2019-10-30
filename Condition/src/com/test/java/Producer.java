package com.test.java;

/**
 * @author yangchao
 * @date 2019/10/30.
 * @description
 */

import java.util.concurrent.ArrayBlockingQueue;

/**
 * 生产者进程
 *
 * 生产者 - 消费者模式
 *    共同维护一个存储队列
 *    队列特点：
 *    队列满时，阻塞生产者，线程进入等待状态。
 *    队列为空时，阻塞消费者，线程进入等待状态。
 */
public class Producer extends Thread {
    /**
     * 生产者维护的生产队列，指明队列存储元素的大小
     */
    protected ArrayBlockingQueue queue;

    public Producer(ArrayBlockingQueue queue,String name) {
        super(name);
        this.queue = queue;
    }

    /**
     * 生产者生产线程
     */
    @Override
    public void run() {
        try {
            Thread.sleep(100);
            Object obj = new Object();
            System.out.println(Thread.currentThread().getName()+" 正在生产");
            //模拟生产者的生产过程
            queue.put(obj);
            System.out.println(Thread.currentThread().getName()+" 生产了一件商品。。。");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
