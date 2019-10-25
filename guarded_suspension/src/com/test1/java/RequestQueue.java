package com.test1.java;

/**
 * @program: java_performance_optimization
 * @Author:chenxuebing
 * @Date:2019-10-18 11:12
 * @Description:(描述)
 */

import java.util.LinkedList;

/**
 * 请求队列： ServiceThread和ClientThread共同维护的对象
 *    属性：
 *       LinkdList: 存储客户端的请求
 *    方法：
 *       addRequest(): 添加请求
 *       getRequest(): 获取请求
 */
public class RequestQueue {
    /**
     * 请求队列，
     */
    protected LinkedList requestQueue = new LinkedList();

    /**
     * 获取请求
     */
    public synchronized Request getRequest(){
        //获取请求时先判断队列中是否有请求，若没有让线程进入当待状态
        if(requestQueue.size() == 0){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //有请求，返回链表第一个元素，并移除，remove()默认移除链表第一个元素，并返回移除值
        //当链表没有元素时，调用remove()方法会抛NoSearchElementException
        return (Request) requestQueue.remove();
    }

    /**
     * 添加请求
     */
    public synchronized void addRequest(Request request){
        requestQueue.add(request);
        //当用户添加请求后，队列存在数据，唤醒服务端的等待线程
        notifyAll();
    }
}
