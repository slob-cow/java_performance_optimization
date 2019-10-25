package com.test.java;

/**
 * @program: java_performance_optimization
 * @Author:chenxuebing
 * @Date:2019-10-18 8:53
 * @Description:(描述)
 */

import java.util.LinkedList;

/**
 * 请求队列：
 *   属性：queue，用于存储客户请求的链表集合
 *   方法：getRequest(),获取链表中的请求
 *        addRequest(),添加客户情求
 */
public class RequestQueue {
    /**
     * 内部结构：链表集合，充当存储请求的缓冲区
     */
    protected LinkedList queue = new LinkedList();

    /**
     * 获取用户的请求
     */
    public synchronized Request getRequest(){
        //当服务端获取请求时，先判断队列中是否有待处理的请求，没有则让线程进入等待状态
        if(queue.size() == 0){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //队列中有请求则通过remove()中获取请求，并移除，使用remove()默认移除链表第一个元素，并返回移除的值，
        //当链表中没有元素，调用remove()会抛出NoSerachElementException
        return (Request) queue.remove();
    }
    /**
     * 添加客户的请求
     */
    public synchronized void addRequest(Request request){
        queue.add(request);
        //唤醒等待的服务线程
        notifyAll();
    }
}
