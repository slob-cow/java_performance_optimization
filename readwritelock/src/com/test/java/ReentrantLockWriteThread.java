package com.test.java;

import java.util.concurrent.CountDownLatch;

/**
 * @author yangchao
 * @date 2019/10/30.
 * @description
 */
public class ReentrantLockWriteThread implements Runnable {
    private CountDownLatch countDownLatch;
    private ReentrantLock_RW reentrantLockRw;

    public ReentrantLockWriteThread(ReentrantLock_RW reentrantLockRw, CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
        this.reentrantLockRw = reentrantLockRw;
    }

    @Override
    public void run() {
        try {
            reentrantLockRw.handleWrite(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            //线程执行完，线程数减一
            countDownLatch.countDown();
        }
    }
}
