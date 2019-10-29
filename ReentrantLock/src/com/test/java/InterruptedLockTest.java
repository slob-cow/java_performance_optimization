package com.test.java;

/**
 * @author yangchao
 * @date 2019/10/29.
 * @description
 */

/**
 * 测试优选处理中断的锁，在等待期间，可以优先的处理中断
 *
 */
public class InterruptedLockTest {
    public static void main(String[] args){
        InterruptedLock interruptedLock =  new InterruptedLock();
        Thread first = new Thread(interruptedLock, "FirstThread");
        Thread second = new Thread(interruptedLock, "SecondThread");
        first.start();
        second.start();
        //线程中断
        try {
            Thread.sleep(600);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        second.interrupt();
    }
}
