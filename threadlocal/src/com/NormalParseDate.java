package com;

/**
 * author:chenxuebing
 * Date:2019/11/1
 * Time:13:51
 */

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 不使用ThreadLocal进行时间装换时出现的问题
 *     多个线程共同使用一个sdf对象，SimpleDataFormat内部维护着一个Caledar对象
 *     Caledar对象存储着parse(dateStr)或format(date)中dateStr、date的信息
 *     Caledar执行两个操作
 *       claer(); 清楚维护的date或dateStr的信息
 *       getTime(); 获取date
 *
 *     当所有的线程共用一个SimpleDateFormat对象时，使用同一个Calendar引用
 *     此时，出现问题：
 *     线程A调用parse(), 并没有getTime（），此时轮到了线程B执行parse(),线程B执行完后也clear(),线程A, getTime（）
 *     最后得到的是线程B的时间
 *
 *     ThreadLocal: 解决了static修饰的共享变量内部操作不一致的问题。
 */
public class NormalParseDate implements Runnable{
    /**
     * 多个线程共享的变量
     */
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");

    int i = 0;

    public NormalParseDate(int i) {
        this.i = i;
    }

    /**
     * 日期装换方法
     */

    @Override
    public void run() {
        try {
            //所有的线程使用同一个sdf
            Date date = sdf.parse("2017-08-02 11:22:"+ i % 60);
            System.out.println(i+" : "+date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
    /**
     * 创建线程
     */
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(10);
        for(int i = 0; i < 100; i++){
            executor.execute(new NormalParseDate(i));
        }
    }
}