package com.test.java;

/**
 * @program: java_performance_optimization
 * @Author:chenxuebing
 * @Date:2019-10-18 10:11
 * @Description:(描述)
 */

/**
 * 模拟客户端发送请求，服务端处理请求
 */
public class ClientAndService {
    public static void main(String[] args) {
        //客户端和服务端共享的请求队列
        RequestQueue queue = new RequestQueue();
        //客户端发送请求
        ClientThread clientThread = new ClientThread(queue);
        for(int i = 0; i < 10; i++){
            new Thread(clientThread,"ClientThread"+i).start();
        }
        //服务端处理请求
        ServiceThread serviceThread = new ServiceThread(queue);
        for(int i = 0; i < 10; i++){
            new Thread(serviceThread,"ServiceThread"+i).start();
        }
        //结论：服务端处理请求的速度比发送请求慢，因为加入了缓存的队列，当客户端结束发送请求，服务端依然可以从缓存队列中取出客户的
        //请求并处理，保证了客户的请求不会丢失。
    }
}
