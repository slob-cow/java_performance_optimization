package com.test.java;

/**
 * @author yangchao
 * @date 2019/10/28.
 * @description
 */
public class VTest {
    public static void main(String[] args) {
        VolatileTest thread = new VolatileTest();
        thread.start();
        thread.stopMe();

    }
}
