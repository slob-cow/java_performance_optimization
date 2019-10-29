package com.test.java;

/**
 * @author yangchao
 * @date 2019/10/29.
 * @description
 */
public class TryLockTest {
    public static void main(String[] args) throws InterruptedException {
        TryLock tryLock = new TryLock();
        Thread first = new Thread(tryLock,"FirstThread");
        Thread second = new Thread(tryLock, "SecondThread");
        first.start();
        second.start();
        Thread.sleep(600);
        //中断second线程
        second.interrupt();

    }
}
