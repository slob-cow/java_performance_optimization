package com.test.java;

import java.util.concurrent.CountDownLatch;

/**
 * @author yangchao
 * @date 2019/10/29.
 * @description
 */
public class ReentrantLockReadThreadTest {
    final static CountDownLatch countDownLatch = new CountDownLatch(200);
    //其实开启200个线程读取lock中值的速率
    public static void main(String[] args) throws InterruptedException {
        ReentrantLock_RW reentrantLockRw = new ReentrantLock_RW();
        ReentrantLockReadThread readThread = new ReentrantLockReadThread(reentrantLockRw, countDownLatch);
        long time = System.currentTimeMillis();
        for(int i = 0; i < 200; i++){
            Thread t = new Thread(readThread);
            t.start();
        }
        //将主线程挂起,当countdown()数量大于0时，恢复主线程。
        countDownLatch.await();
        System.out.println(System.currentTimeMillis() - time);
    }
}
