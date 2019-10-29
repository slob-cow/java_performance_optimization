package com.test.java;

/**
 * @author yangchao
 * @date 2019/10/28.
 * @description
 */
public class Test {
    public static void main(String[] args) {
        BlockQueue queue = new BlockQueue();
        //两个线程，一个线程获取队列的数据，如果队列有数据则获取数据，如果没有则等待
        Thread popThread = new Thread() {
            @Override
            public void run() {
                while (true) {
                    //获取队列的数据
                    try {
                        queue.pop();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        popThread.start();
 /*      Thread putThread = new Thread(){
            @Override
            public void run(){
                while(true) {
                    String a = "1";
                    queue.put(a);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        putThread.start();
    }*/
    }
}
