package com.test.java;

import java.util.concurrent.CountDownLatch;

/**
 * @author yangchao
 * @date 2019/10/30.
 * @description
 */
public class ReentrantLockWriteThreadTest {
    final static CountDownLatch countDownLatch =  new CountDownLatch(200);
    public static void main(String[] args) throws InterruptedException {
        ReentrantLock_RW reentrantLockRw = new ReentrantLock_RW();
        long start = System.currentTimeMillis();
        for(int i = 0; i < 200; i++){
            Thread t = new Thread(new ReentrantLockWriteThread(reentrantLockRw, countDownLatch));
            t.start();
        }
        countDownLatch.await();
        System.out.println(System.currentTimeMillis() - start);
    }
}
