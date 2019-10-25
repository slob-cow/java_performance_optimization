package com.test2.java;

/**
 * @program: java_performance_optimization
 * @Author:chenxuebing
 * @Date:2019-10-16 14:41
 * @Description:(描述)
 */

/**
 * 真正的数据返回类
 */
public class RealData implements Data{
    private String requestStr;

    /**
     * 模拟在构造RealData对象时要花费很多时间
     */
    public RealData(String requestStr) {
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < 100; i++){
            sb.append(requestStr);
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String result() {
        return "亲~ ，您的货物已经到件了哦！";
    }
}
