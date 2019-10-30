package com.test.java;

/**
 * @author yangchao
 * @date 2019/10/29.
 * @description
 */

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 使用ReadWriteLock进行读写操作
 */
public class ReadWriteLock_RW {
    private static int value;
    private static ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();


    /**
            * 读取锁
    */
    private static Lock readLock = readWriteLock.readLock();

    /**
     * 写入锁
     */
    private static Lock writeLock = readWriteLock.writeLock();

    /**
     * 读操作
     */
    public Object handleRead() throws InterruptedException {
        try {
            readLock.lock();
            Thread.sleep(1);
            return value;
        }finally {
            //释放锁
            readLock.unlock();
        }

    }

    /**
     * 写操作
     */
    public void handleWrite(int index) throws InterruptedException {
        try{
            //获取锁
            writeLock.lock();
            Thread.sleep(1);
            value = index;
        }finally {
            //释放锁
            writeLock.unlock();
        }
    }

}
