package com.test1.java;

/**
 * @program: java_performance_optimization
 * @Author:chenxuebing
 * @Date:2019-10-17 14:49
 * @Description:(描述)
 */

/**
 * 继承Worker类，定义handle()的业务逻辑
 */
public class PlushWorker extends Worker{
    /**
     * 对任务进行处理，在run()方法中调用该方法
     * @param input
     * @return
     */
    @Override
    public Object handle(Object input){
        int i = (Integer)input;
        return i * i * i;
    }
}
