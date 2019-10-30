package com.test.java;

/**
 * @program: java_performance_optimization
 * @Author:chenxuebing
 * @Date:2019-10-09 16:13
 * @Description:(描述)
 */

import java.util.StringTokenizer;

/**
 * 字符串分割
 */
public class StringSplit {
    public static void main(String[] args) {
        String orgStr = null;
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < 10000; i++){
            sb.append(i);
            sb.append(";");
        }
        orgStr = sb.toString();
        //对orgStr字符串进行分割
        Long start = System.currentTimeMillis();

        /**
         * 使用split分割
         */
        for(int i = 0; i < 10000; i++){
            orgStr.split(";");
        }
        //使用split分割耗时2655
        System.out.println(System.currentTimeMillis()-start);

        /**
         * 使用StringTokenier分割
         */
        StringTokenizer st = new StringTokenizer(orgStr,";");
        Long start1 = System.currentTimeMillis();
        for(int i = 0; i < 10000; i++){
            while(st.hasMoreElements()){
                st.nextToken();
            }
            st = new StringTokenizer(orgStr,";");
        }
        //使用StringTokenizer分割耗时2719秒，在使用个StringTokenizer分割时还有创建和销毁StringTokenizer对象的时
        // 因此总体来说，使用StringTokenizer的性能比split的性能要好
        //耗时2719
        System.out.println(System.currentTimeMillis()-start1);

        /**
         * 使用indexOf和subString 来分割
         */
        String temp = orgStr;
        Long start2 = System.currentTimeMillis();
        for(int i = 0; i < 10000; i++){
            while(true) {
                String splitStr = null;
                //获取第一个;所在的位置
                int j = temp.indexOf(';');
                if(j < 0){
                    break;
                }
                splitStr = temp.substring(0, j);
                temp = temp.substring(j + 1);
            }
            temp = orgStr;
        }
        //耗时413933
        System.out.println(System.currentTimeMillis()-start2);
    }
}
