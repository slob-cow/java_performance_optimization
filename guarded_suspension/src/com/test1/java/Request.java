package com.test1.java;

/**
 * @program: java_performance_optimization
 * @Author:chenxuebing
 * @Date:2019-10-18 10:58
 * @Description:(描述)
 */

/**
 * 加入Future模式的Guarded Worker：
 *  使用场景：
 *    当客户端请求服务后不知道服务进程何时处理这个请求，也不知道需要处理多久，但又必须使用请求的返回值，可以使用Future模式实现。
 */

import java.util.LinkedList;

/**
 * 构造请求类
 *   属性：
 *     name: 请求信息
 *     Data: 返回给客户端的处理结果
 *
 */
public class Request {
    /**
     * 请求信息
     */
    private String name;

    /**
     * 响应信息
     */
    private Data response;

    public Request(String name) {
        this.name = name;
    }

    @Override
    public String toString(){
        return name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Data getResponse() {
        return response;
    }

    public void setResponse(Data response) {
        this.response = response;
    }
}
