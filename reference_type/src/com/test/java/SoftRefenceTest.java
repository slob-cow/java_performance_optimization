package com.test.java;

/**
 * @program: java_performance_optimization
 * @Author:chenxuebing
 * @Date:2019-10-14 19:05
 * @Description:(描述)
 */

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;

/**
 * 软引用：
 * 软引用的特点：
 *
 *
 */
public class SoftRefenceTest {
    public static ReferenceQueue<MyObject> softQueue = null;
    private static class CheckRefQueue extends Thread{
        Reference<MyObject> ref = null;
        @Override
        public void run(){
            //检查引用队列，监控对象的回收情况，当对象被回收时，软引用会被加入队列中，通过remove方法移除软引用。
            try {
                //如果软引用的对象被回收，该软引用会被加入softQueue队列中，通过remove移除队列中对应的元素，有元素返回该引用，没有返回null
                ref = (Reference<MyObject>) softQueue.remove();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(ref != null){
                System.out.println("obj for SoftRefernce is " + ref.get());
            }
        }
    }
    public static void main(String[] args) throws InterruptedException {
        //新建一个对象，创建该对象的强引用
        MyObject obj = new MyObject();
        //创建引用队列
        softQueue = new ReferenceQueue();
        //创建软引用对象
        SoftReference<MyObject> softRef = new SoftReference(obj, softQueue);
        new CheckRefQueue().start();
        //去除强引用，此时，MyObject对象变为弱引用。
        obj = null;
        System.gc();
       //
        // System.out.println(softQueue.remove().get());
        //检查引用队列，监控对象回收情况
        //new CheckRefQueue()).start()
    }
}
