package com.test.java;

/**
 * @author yangchao
 * @date 2019/10/29.
 * @description
 */

import java.util.concurrent.locks.ReentrantLock;

/**
 * 测试ReentrantLock获取锁的方法有什么不同
 *    使用lock()来获取锁
 */
public class Lock implements Runnable{
    //保证每一个线程都使用同一把锁
    private static ReentrantLock lock = new ReentrantLock();


    @Override
    public void run() {
        while (true) {
            //获得锁后，模拟线程进行业务操作
            try {
                //使用lock()获取锁
                lock.lock();
                //输出当前获得锁的线程对象
                System.out.println("lock " + Thread.currentThread().getName());
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName()+ " is Interrupted");
            } finally {
                //需要在finally中显示的释放锁，否则，程序发生异常，无法释放锁。
                lock.unlock();
                System.out.println("unlock " + Thread.currentThread().getName());
            }
            break;
        }
    }

}
