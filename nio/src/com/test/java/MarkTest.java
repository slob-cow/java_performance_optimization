package com.test.java;

import java.nio.ByteBuffer;

/**
 * @program: java_performance_optimization
 * @Author:chenxuebing
 * @Date:2019-10-14 10:00
 * @Description:(描述)
 */
public class MarkTest {
    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(15);
        for(int i = 0 ; i < 10 ; i++){
            buffer.put(((byte)i));

        }
        //读写转换
        buffer.flip();
        for(int i = 0 ; i < buffer.limit() ; i++){
            System.out.print(buffer.get());
            if(i == 4){
                //mark = 5，当 i = 4 时，get后，position后移的一位，所以mark = 5
                buffer.mark();
                System.out.print("mark = "+buffer.mark());
            }
        }
        System.out.println();
        System.out.println("原position值 = "+buffer.position());
        //重置position为mark值
        buffer.reset();
        System.out.println("reset后position值 = "+buffer.position());
        while(buffer.hasRemaining()){
            System.out.print(buffer.get());
        }
    }
}
