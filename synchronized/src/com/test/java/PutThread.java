package com.test.java;

/**
 * @author yangchao
 * @date 2019/10/28.
 * @description
 */
public class PutThread implements Runnable {
    private BlockQueue blockQueue;
    PutThread(BlockQueue blockQueue){
        this.blockQueue = blockQueue;
    }
    @Override
    public void run(){
        while(true) {
            String  a = "1";
            blockQueue.put(a);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
