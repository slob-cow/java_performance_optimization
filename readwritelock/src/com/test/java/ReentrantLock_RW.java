package com.test.java;

/**
 * @author yangchao
 * @date 2019/10/29.
 * @description
 */

import java.util.concurrent.locks.ReentrantLock;

/**
 * 使用重入锁进行读写操作
 *    线程的读写使用同一把锁。
 */
public class ReentrantLock_RW {
    private static ReentrantLock lock = new ReentrantLock();
    private static int value ;

    //读操作
    public Object handleRead() throws InterruptedException {
        try {
            //获取锁
            lock.lock();
            //模拟读操作，读操作耗时越多，读写锁的优势越明显
            Thread.sleep(10);
            return value;
        }finally {
            lock.unlock();
        }
    }
    /**
     * 写操作
     */
    public void handleWrite(int i) throws InterruptedException {
        try {
            lock.lock();
            //模拟写操作
            Thread.sleep(1);
            value = i;
        }finally {
            lock.unlock();
        }
    }
}
