package com.test2.java;

/**
 * @program: java_performance_optimization
 * @Author:chenxuebing
 * @Date:2019-10-16 14:41
 * @Description:(描述)
 */
public class Client {
    /**
     * 客户端发送请求后，先返回一个FutureData,并开启一个线程，装配一个RealData到返回的FutureData中
     *
     */
    public Data request(String requestStr){
        //创建一个Future对象
        FutureData future = new FutureData();
        //开启一个线程，创建RealData对象，并将该对象装配到future中
        new Thread(){
            @Override
            public void run(){
                //创建RealData对象
                RealData realData = new RealData(requestStr);
                //装配realData对象到future中
                future.setRealData(realData);
            }
        }.start();
        //用户请求后立即返回一个FutureData对象，执行其它的业务逻辑
        return future;
    }
}
