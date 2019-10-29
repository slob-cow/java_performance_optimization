package com.test.java;

/**
 * @author yangchao
 * @date 2019/10/28.
 * @description
 */

import org.junit.Test;

/**
 * 使用一个boolena型变量，isExist来验证Volatile
 *
 *
 */
public class VolatileTest02 {
    private Boolean isExist = false;

     /**
     * 尝试退出线程
      * 读取非Volatile修饰的变量，从当前的工作线程空间读取，不能及时的发现另一个线程对变量值isExist的修改
      *
    */
    public void tryExist(){
        if(isExist == !isExist){
            System.out.println("2");
            System.exit(0);
        }
    }

    /**
     * 更改isExist的值
     * 当isExist的值修改时，被写入主内存中。
     * 此时，mainThread线程的线程工作内存未能及时的读取isExist的更改，没有将改变值load入线程工作内存，isExist == !isExist很难成立
     *
     */
    public void swapVlaue(){
        isExist = !isExist;
    }

    /**
     * 创建两个线程，一个线程用于不断的执行是否退出操作，另一个线程不断的更改isExist的值
     */
    @Test
    public void test() throws InterruptedException {
        final VolatileTest02 volObj = new VolatileTest02();
        Thread mainThread = new Thread(){
            @Override
            public void run(){
                //不断判断isExist的值，如果isExist = !isExist，程序退出
                System.out.println("mainThread start");
                //线程不断的尝试退出
                while(true){
                    volObj.tryExist();
                }

            }
        };
        mainThread.start();

        Thread swapThread = new Thread(){
            public void run() {
                System.out.println("swapThread start");
                //线程不断的修改isExist的值
                while (true) {
                    volObj.swapVlaue();
                    System.out.println(1);
                }

            }
        };
        swapThread.start();
        Thread.sleep(1000);
    }
}
