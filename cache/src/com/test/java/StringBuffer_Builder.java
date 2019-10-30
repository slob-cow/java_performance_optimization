package com.test.java;

/**
 * @program: java_performance_optimization
 * @Author:chenxuebing
 * @Date:2019-10-09 17:19
 * @Description:(描述)
 */
public class StringBuffer_Builder {
    public static void main(String[] args) {
        StringBuffer buffer = new StringBuffer();
        long start0 = System.currentTimeMillis();
        for(int i =0 ; i < 500000; i++){
            buffer.append(i);
        }
        System.out.println(System.currentTimeMillis() - start0);
        StringBuffer buffer1 = new StringBuffer(58888900);
        long start1 = System.currentTimeMillis();
        for(int j =0 ; j < 500000; j++){
            buffer1.append(j);
        }
        System.out.println(System.currentTimeMillis() - start1);
    }

}
