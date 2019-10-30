package com.test.java;

/**
 * @author yangchao
 * @date 2019/10/29.
 * @description
 */

import java.util.concurrent.CountDownLatch;

/**
 * 比较重入锁与读写锁读数据的性能
 */
public class ReentrantLockReadThread implements Runnable{
    private CountDownLatch countDownLatch;
    private  ReentrantLock_RW reentrantLockRw;
    public ReentrantLockReadThread(ReentrantLock_RW reentrantLockRw, CountDownLatch countDownLatch) {
        this.reentrantLockRw = reentrantLockRw;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        try {
            reentrantLockRw.handleRead();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            //线程执行完将线程挂起
            countDownLatch.countDown();
        }
    }
}
