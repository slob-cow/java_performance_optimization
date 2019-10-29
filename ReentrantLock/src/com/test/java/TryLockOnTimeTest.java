package com.test.java;

/**
 * @author yangchao
 * @date 2019/10/29.
 * @description
 */
public class TryLockOnTimeTest {
    public static void main(String[] args) throws InterruptedException {
        TryLockOnTime tryLockOnTime = new TryLockOnTime();
        Thread first = new Thread(tryLockOnTime, "FirstThread");
        Thread second = new Thread(tryLockOnTime, "SecondThread");
        first.start();
        second.start();
        Thread.sleep(600);
        second.interrupt();
    }
}
