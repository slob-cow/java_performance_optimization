package com.test.java;

/**
 * @author yangchao
 * @date 2019/10/25.
 * @description
 */

import java.util.Random;

/**
 * 测试Vector 和 CopyOnWriteArrayList在get()上的差异
 */
public class AccessListThread implements Runnable{
    protected String name;
    Random ran = new Random();

    public AccessListThread() {
    }

    public AccessListThread(String name) {
        this.name = name;
    }

    @Override
    public void run(){
       for(int i = 0; i < 500; i++){

       }

    }
    public Object getList(int index){
        return list.get(index);
    }
}
