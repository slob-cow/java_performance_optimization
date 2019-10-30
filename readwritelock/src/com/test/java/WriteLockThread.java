package com.test.java;

import java.util.concurrent.CountDownLatch;

/**
 * @author yangchao
 * @date 2019/10/30.
 * @description
 */
public class WriteLockThread implements Runnable{
    private ReadWriteLock_RW readWriteLockrw;
    private CountDownLatch countDownLatch;
    public WriteLockThread(ReadWriteLock_RW readWriteLockrw, CountDownLatch countDownLatch) {
        this.readWriteLockrw = readWriteLockrw;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        try {
            readWriteLockrw.handleWrite(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            //线程执行完将该线程挂起
            countDownLatch.countDown();
        }
    }
}
