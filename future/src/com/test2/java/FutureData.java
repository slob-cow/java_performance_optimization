package com.test2.java;


/**
 * @program: java_performance_optimization
 * @Author:chenxuebing
 * @Date:2019-10-16 14:41
 * @Description:(描述)
 */

/**
 * 该类需要使用到线程的唤醒机制：
 *       使用isReady来监控对象是否被注入，isReady = false,对象未注入，线程请求request()，使用wait()让线程进入等待状态
 *       isReady = true，注入对象，使用notifyAll()唤醒等待线程。
 *
 *       原因： RealData的方法构造很慢，当调用FutureData的result()来获取真实数据时，RealData对象未被注入，因为FutureData的result()
 *             是调用了RealData的result()方法，此时，对象未注入，抛出NullPointException。
 */
public class FutureData implements Data {
    /**
     * 装配对象
     */
    RealData realData = null;

    /**
     * 装配标识符，监控装配对象是否成功注入
     */
    Boolean isReady = false;

    /**
     * 注入RealData
     * @return
     */
    public synchronized void setRealData(RealData realData){
        if(isReady){
            return;
        }
        this.realData = realData;
        //注入对象后，将isReady设置为true
        isReady = true;
        //唤醒等待的线程
        notifyAll();
    }

    /**
     * 实际上使用RealData获取真实的数据并返回结果
     * @return
     */
    @Override
    public synchronized String result() {
        //当对象未被注入时，等待对象的注入
        if(!isReady){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return realData.result();
    }
}
