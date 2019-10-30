package com.test.java;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author yangchao
 * @date 2019/10/30.
 * @description
 */
public class Test {
    public static void main(String[] args) {
        final int[] a = {1, 2, 4, 40};
        a[1] = 7;
        final int b = 1;
        //结论： final修饰的变量，变量的引用不能改变，但可以改变引用的内容。

        //俩个不同的队列，使用的是不同的一把锁
        ArrayBlockingQueue queue = new ArrayBlockingQueue(20);
        ArrayBlockingQueue queue1 = new ArrayBlockingQueue(20);


    }
}
