package com.test1.java;

/**
 * @program: java_performance_optimization
 * @Author:chenxuebing
 * @Date:2019-10-18 15:30
 * @Description:(描述)
 */

/**
 * 客户端发送请求，服务端处理请求
 */
public class ClientService {
    public static void main(String[] args) {
        //客户进程和服务进程共同维护一个请求队列
        RequestQueue requestQueue = new RequestQueue();
        //客户端请求
        for(int i = 0; i < 10; i++){
           new ClientThread(requestQueue,"ClientThread"+i).start();
        }
        //服务端请求
        for(int i = 0; i < 10; i++){
            new ServiceThread(requestQueue, "ServiceThread"+ i).start();
        }
    }
}
