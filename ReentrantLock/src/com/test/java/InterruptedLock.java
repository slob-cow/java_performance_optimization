package com.test.java;

/**
 * @author yangchao
 * @date 2019/10/29.
 * @description
 */

import java.util.concurrent.locks.ReentrantLock;

/**
 * 测试使用lockInterruptibly()来获取锁
 *    lockInterruptibly(): 获取锁，当优先响应中断
 */
public class InterruptedLock implements Runnable{
    /**
     *   创建共有的锁对象
     */
    private static ReentrantLock lock = new ReentrantLock();
    @Override
    public void run() {
        while (true) {
            //获取锁
            try {
                //lock.lockInterruptibly()方法调用放在try的外部，否则，若线程发生中断，finally调用lock.unlock()会抛出IllegalMonitorStateExecption
                lock.lockInterruptibly();
                //业务逻辑要放在另一个try里边，因为当线程调用interrupt()会抛出InterruptedException，再finally调用unlock()会抛IllegalMonitorStateExecption
                try {
                    //输出当前获得锁的线程对象
                    System.out.println("lock " + Thread.currentThread().getName());
                    //模拟获得锁后的业务逻辑
                    Thread.sleep(1000);
                } finally {
                    //释放锁
                    System.out.println("unlock "+Thread.currentThread().getName());
                    lock.unlock();
                    break;
                }
            }catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " is interrupted");
            }
         }
    }
}
