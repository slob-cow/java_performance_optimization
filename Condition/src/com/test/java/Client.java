package com.test.java;

/**
 * @author yangchao
 * @date 2019/10/30.
 * @description
 */

import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 开启多个线程进行生产，开启多个线程进行消费
 */

public class Client {
    public static void main(String[] args) {
        ArrayBlockingQueue queue = new ArrayBlockingQueue(20);
        ExecutorService executor = Executors.newFixedThreadPool(200);
        Producer producer1 = new Producer(queue,"producer - 1");
        Producer producer2 = new Producer(queue,"producer - 2");
        Producer producer3 = new Producer(queue,"producer - 3");
        Consumer consumer1 = new Consumer(queue,"consumer - 1");
        Consumer consumer2 = new Consumer(queue,"consumer - 2");
        Consumer consumer3 = new Consumer(queue,"consumer - 3");
        //开启多个线程进行生产
        executor.execute(producer1);
        executor.execute(producer2);
        executor.execute(producer3);

        //开启多个线程进行消费
        executor.execute(consumer1);
        executor.execute(consumer2);
        executor.execute(consumer3);

    }
}
