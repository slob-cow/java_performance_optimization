package com.test.java;

/**
 * @author yangchao
 * @date 2019/10/28.
 * @description
 */

/**
 * Volatile关键字：
 *   1）、保证线程中变量的改变对其他线程是可见的。
 *   2）、当某一线程的变量发生改变，变量的值及时的写入主内存
 *   3）、Volatile修饰的变量，迫使所有的线程都到主内存中读取数据，实现了线程的可见性
 */
public class VolatileTest extends Thread {
    private Boolean stop = false;
    public void  stopMe(){
        stop = true;
    }
    @Override
    public void run(){
        int i = 0;
        while(!stop){
            i++;
        }
        //当stop = true,停止循环，并输出
        System.out.println("stop Thread");
    }
}
