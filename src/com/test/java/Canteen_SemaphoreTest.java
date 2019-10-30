package com.test.java;

/**
 * @author yangchao
 * @date 2019/10/30.
 * @description
 */

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * 测试信号量的使用，开启20个线程
 */
public class Canteen_SemaphoreTest {
    public static void main(String[] args) {
        //设置信号量的大小,一次食堂只能容纳5个人吃饭
        Semaphore semaphore = new Semaphore(5);
        ExecutorService executor = Executors.newFixedThreadPool(20);
        Canteen_SemaphoreThread canteenThread = new Canteen_SemaphoreThread(semaphore);
        for(int i = 0; i < 20; i++){
            executor.execute(canteenThread);
        }
    }
}
