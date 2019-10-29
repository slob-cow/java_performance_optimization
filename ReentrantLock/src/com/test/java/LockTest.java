package com.test.java;

/**
 * @author yangchao
 * @date 2019/10/29.
 * @description
 */
public class LockTest {
    public static void main(String[] args) {
        Lock reentrantLock = new Lock();
        Thread first = new Thread(reentrantLock,"FirstThread");
        Thread second = new Thread(reentrantLock,"SecondThread");
        first.start();
        try {
            Thread.sleep(600);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //中断线程
        second.start();
        /**
         * 设置线程的中断位,调用second.interrupt()，线程的中断位置为true，
         * 线程的wait()、sleep()、jion()等方法会监控中断位的状态，若状态为true则抛出InterruptedExecption
         * 此时，线程不是停止状态，可以执行catch中的业务逻辑。
         */

        second.interrupt();

    }
    //结论：使用lock()操作，如果线程未得到锁将会一直等待，直到有其他的线程释放锁
}
