package com.test.java;

/**
 * @author yangchao
 * @date 2019/10/30.
 * @description
 */

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 使用Condition来构建一v个阻塞队列
 *    模拟ArrayBlockQueue的阻塞模式，
 *    消费者线程：put(E e)，当队列满时线程进入等待状态
 *    生产者线程：take(), 当队列为空时，线程进入等待状态
 */
public class Con_BlockQueue {
    /**
            *   定义锁对象
    */
    private static ReentrantLock lock = new ReentrantLock();

    /**
     * 获取Condition对象，与锁关联，得到锁的监视器
     */
    private static Condition notEmpty = lock.newCondition();
    private static Condition notFull = lock.newCondition();

    /**
     * 定义一个数组，存储元素
     */
    protected Object[] item = new Object[10];

    /**
     * 记录数组中元素的个数
     */
    private int count;

    /**
     * 添加元素
     */
    public void put(Object o){
        try{
            //获取锁对象
            lock.lockInterruptibly();
            try {
                //判断当前队列是否已满
                while(this.item.length == count){
                    //队列已满，线程进入等待状态
                    notEmpty.await();
                }
                //队列未满，执行插入操作
                insert(o);

            }finally {
                lock.lock();
            }
        } catch (InterruptedException e) {
            //线程处于中断状态，使线程由await状态转为执行状态。
            notFull.signal();
        }
    }

    /**
     * 元素的插入操作
     */
    public void insert(Object o){
        item[count+1] = o;
        count++;
        //唤醒一个正在等待的线程
        notEmpty.signal();
    }

    /**
     * 获取元素
     */
    public void take(){
        //获取锁对象
        try {
            lock.lockInterruptibly();
            //判断队列是否为空，若为空线程进入等待状态
            try{
                while(count == 0){
                    notFull.signal();
                }
                Object o = extract();

            }finally{

            }
        } catch (InterruptedException e) {
            notEmpty.signal();
        }
    }

    /**
     * 取出元素
     */
    public Object extract(){
        Object[] item = this.item;
        //获取第一个元素
        Object o =  item[0];
        item[0] = null;
        count --;
        notEmpty.signal();
        return o;

    }

}
