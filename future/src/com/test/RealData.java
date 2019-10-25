package com.test;

import java.util.concurrent.Callable;

/**
 * @program: java_performance_optimization
 * @Author:chenxuebing
 * @Date:2019-10-16 16:18
 * @Description:(描述)
 */
public class RealData implements Callable {
    private String requestStr;
    /**
     *  轻量级的构造方法
     */
    public RealData(String requestStr) {
        this.requestStr = requestStr;
    }

    /**
     * 将复杂的业务逻辑都放在call方法中
     * @return
     * @throws Exception
     */
    @Override
    public Object call(){
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < 10; i++){
            sb.append(requestStr);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //指定FutureTask的返回对象
        return "亲~， 您的香水已到货！";
    }
}
