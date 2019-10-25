package com.test2.java;

/**
 * @program: java_performance_optimization
 * @Author:chenxuebing
 * @Date:2019-10-16 13:55
 * @Description:(描述)
 */

/**
 * Future模式：
 *     使用并发的设计思想，解决客户端发送请求到应用程序，等待响应数据时间过长的问题.
 *     实现：
 *     1.用户发送client请求服务到应用程序，先返回一个虚假的数据FutureData类，并开启一个新的线程，用于装配真正的数据返回对象
 *     2.提供一个接口类Data,类中提供一个接口方法，虚假类FutureData和真实类RealData分别实现对应的接口方法。
 *     2.将新的线程装配成功的RealData对象加入FutureData中，FutureData相当于RealData的代理对象，在接口方法中调用RealData，的到应用程序真实的响应数据。
 *  *
 */

/**
 * 系统启动类
 */
public class ClientService {
    public static void main(String[] args) {
        //调用Client，发送请求
        Client client = new Client();
        //得到一个FutureData对象
        Data data = client.request("channel香水 x 1：购买");
        System.out.println("我在执行其他的业务");
        //模拟客户端发送请请求后，继续执行其他的业务逻辑
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //用户的到真实的数据对象
        System.out.println(data.result());
    }
}
