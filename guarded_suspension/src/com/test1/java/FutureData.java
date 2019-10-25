package com.test1.java;

/**
 * @program: java_performance_optimization
 * @Author:chenxuebing
 * @Date:2019-10-18 11:30
 * @Description:(描述)
 */

/**
 * 虚假数据类: 轻量级对象
 */
public class FutureData implements Data {
    /**
     *  内部维护一个RealData
     */
   protected RealData realData;

    /**
     * 使用一个变量来监控是否成功注入RealData
     */
    private boolean isReady = false;

    /**
     * 注入真实的RealData
     */
    public synchronized void setRealData(RealData realData){
        if(isReady){
            return;
        }
        this.realData = realData;
        //注入成功，将isReady值设为true,唤醒等待的线程
        isReady = true;
        notifyAll();
    }

    /**
     * 获取真实的返回数据
     */
    @Override
    public synchronized String getResult() {
        //先判断RealData对象是否注入成功，若没有则让线程进入等待桩状态
        if(!isReady){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //注入成功，返回真实的处理结果
        return realData.getResult();
    }
}
