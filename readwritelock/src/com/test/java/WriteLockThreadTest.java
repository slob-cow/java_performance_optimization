package com.test.java;

import java.util.concurrent.CountDownLatch;

/**
 * @author yangchao
 * @date 2019/10/30.
 * @description
 */
public class WriteLockThreadTest {
    final static CountDownLatch countDownLatch = new CountDownLatch(200);
    public static void main(String[] args) throws InterruptedException {
        ReadWriteLock_RW readWriteLockRw = new ReadWriteLock_RW();
        WriteLockThread readThread = new WriteLockThread(readWriteLockRw, countDownLatch);
        long time = System.currentTimeMillis();
        for(int i = 0; i < 200; i++){
            Thread t = new Thread(readThread);
            t.start();
        }
        countDownLatch.await();  //一定要等到countDown()方法执行完毕后才使用,将主线程挂起
        System.out.println(System.currentTimeMillis() - time);
    }
}
