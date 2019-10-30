package com.test.java;

/**
 * @author yangchao
 * @date 2019/10/29.
 * @description
 */

import java.util.concurrent.CountDownLatch;

/**
 * 读入锁线程
 */
public class ReadLockThread implements Runnable{
    private ReadWriteLock_RW readWriteLockrw;
    private CountDownLatch countDownLatch;
    public ReadLockThread(ReadWriteLock_RW readWriteLockrw, CountDownLatch countDownLatch) {
        this.readWriteLockrw = readWriteLockrw;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        try {
            readWriteLockrw.handleRead();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            //线程执行完将该线程挂起
            countDownLatch.countDown();
        }
    }
}
