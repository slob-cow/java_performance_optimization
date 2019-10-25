package com.test1.java;

/**
 * @program: java_performance_optimization
 * @Author:chenxuebing
 * @Date:2019-10-18 11:32
 * @Description:(描述)
 */

/**
 * 真实的数据类： 是一个重量级对象
 */
public class RealData implements Data {
    /**
     * 请求信息
     */
    private Request request;
    /**
     * 模拟构造方法构造很慢
     */
    public RealData(Request request){
        this.request = request;
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @Override
    public String getResult() {
        return "我处理了 "+request;
    }
}
