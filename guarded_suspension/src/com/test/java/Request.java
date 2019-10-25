package com.test.java;

/**
 * @program: java_performance_optimization
 * @Author:chenxuebing
 * @Date:2019-10-18 8:52
 * @Description:(描述)
 */

/**
 * Guarded Suspension : 保护暂存模式。
 * 应用场景：
 *     当多个客户端去请求服务端应用程序，服务端无法快速的处理客户端的请求，此时，需要保存客户端的请求，将客户端的请求保存
 *     在一个缓存队列中，等待服务端处理。
 *
 * 结构： 由服务线程、客户线程、请求队列（用来存放客户的请求）构成，服务线程和客户线程共同维护一个请求队列。
 *
 */

/**
 * 构造一个请求对象
 */
public class Request {
    private String name;
    public Request(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString(){
        return name;
    }
}
