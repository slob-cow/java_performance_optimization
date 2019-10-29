package com.test.java;

/**
 * @author yangchao
 * @date 2019/10/29.
 * @description
 */

import java.util.concurrent.locks.ReentrantLock;

/**
 * tryLock()：尝试获取锁
 */
public class TryLock implements Runnable{
    /**
     * 锁对象
    */
    private static ReentrantLock lock = new ReentrantLock();
    @Override
    public void run() {
        while(true){
            //尝试获取锁，立即返回获取结果，成功则返回true,失败返回false
           if( lock.tryLock()){
               try {
                   System.out.println("lock "+Thread.currentThread().getName());
                   Thread.sleep(1000);
               } catch (InterruptedException e) {
                   System.out.println(Thread.currentThread().getName()+" is Interrupted");
               }finally{
                   //释放锁
                  lock.unlock();
                   System.out.println("unlock "+ Thread.currentThread().getName());
                   break;
               }
           }else{
               //获取锁失败
               System.out.println("unable lock "+Thread.currentThread().getName());
           }
        }
    }
}
