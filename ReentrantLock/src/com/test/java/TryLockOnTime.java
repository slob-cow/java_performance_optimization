package com.test.java;

/**
 * @author yangchao
 * @date 2019/10/29.
 * @description
 */

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 在指定时间里等待锁
 */
public class TryLockOnTime implements Runnable{
    private static ReentrantLock lock = new ReentrantLock();
    @Override
    public void run() {
        while(true) {
            //获取锁
            try {
                //获取锁之前，先判断线程的中断状态，若中断状态为true,抛出InterruptedExecption
                if (lock.tryLock(500, TimeUnit.MILLISECONDS)) {
                    try {
                        System.out.println("lock " + Thread.currentThread().getName());
                        Thread.sleep(1000);

                    } finally {
                        System.out.println("unlock " + Thread.currentThread().getName());
                        //释放锁
                        lock.unlock();
                    }
                    break;
                } else {
                    System.out.println("unable lock " + Thread.currentThread().getName());
                }
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " is Interrupted");
            }
        }
    }
}
