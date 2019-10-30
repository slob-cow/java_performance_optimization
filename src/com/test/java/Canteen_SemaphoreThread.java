package com.test.java;

/**
 * @author yangchao
 * @date 2019/10/30.
 * @description
 */

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * 指定多个线程同时访问某一个资源
 *     模拟食堂吃饭，一次食堂只能容纳5个人同时吃饭
 */
public class Canteen_SemaphoreThread implements Runnable{

    /**
     *   控制食堂的人流量，一次只允许5个人同时吃饭
     */
    private Semaphore semaphore ;

    public Canteen_SemaphoreThread(Semaphore semaphore) {
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        //获取准入许可，相当于获取锁,若无法获取许可，线程则一直等待释放许可，等待过程中优先响应中断
        try {
            /**
             * 使用信号量来锁住一个资，源传入信号量时，指明允许资源同时访问的线程个数。
             */
            semaphore.acquire();
            System.out.println("我正在吃饭。。。 "+Thread.currentThread().getName());
            Thread.sleep(100);
            System.out.println("我吃完了、、、 "+Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            //释放一个许可
            semaphore.release();
        }

    }
}
