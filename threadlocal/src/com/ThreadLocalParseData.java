package com;

/**
 * author:chenxuebing
 * Date:2019/11/1
 * Time:13:54
 */

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 使用ThreadLocal线程局部变量来解决线程间共享变量内部操作不一致问题
 */
public class ThreadLocalParseData implements Runnable{
    //线程共用一个threadLocal对象
    private static ThreadLocal<SimpleDateFormat> threadLocal = new ThreadLocal<>();
    int i = 0;

    public ThreadLocalParseData(int i) {
        this.i = i;
    }

    @Override
    public void run() {
        //判断当前线程是否有SimpleDateFormat对象，有则使用，没有则创建
        if(threadLocal.get() == null){
            //如果没有就给当前线程创建一个, 每一个线程都有一个自己的SimpleDateFormat对象
            threadLocal.set(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        }
        //有，则直接使用
        try {
            Date date = threadLocal.get().parse("2017-2-21 14:29:" + i % 60);
            System.out.println(i+":"+date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        //创建线程对象，每个线程都有一个SimpleDateFormat对象
        ExecutorService executor = Executors.newFixedThreadPool(10);
        for(int i = 0; i < 100; i++){
            executor.execute(new ThreadLocalParseData(i));
        }
    }
}
