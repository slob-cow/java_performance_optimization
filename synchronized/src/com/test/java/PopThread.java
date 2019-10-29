package com.test.java;

/**
 * @author yangchao
 * @date 2019/10/28.
 * @description
 */
public class PopThread implements Runnable{
    private BlockQueue blockQueue;

    PopThread(BlockQueue blockQueue){
        this.blockQueue = blockQueue;
    }
    @Override
    public void run() {
        while (true) {
            try {
                blockQueue.pop();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

