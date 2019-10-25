package com.test.java;

import java.nio.ByteBuffer;

/**
 * @program: java_performance_optimization
 * @Author:chenxuebing
 * @Date:2019-10-14 11:21
 * @Description:(描述)
 */
public class AsReadOnlyBuffer_Test {
    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(15);
        for(int i = 0; i < 10; i++){
            buffer.put((byte)i);
        }
        //创建只读缓冲区
        ByteBuffer readBuffer = buffer.asReadOnlyBuffer();
        System.out.println(buffer);
        System.out.println(readBuffer);
        readBuffer.flip();
        while(readBuffer.hasRemaining()){
            System.out.print(readBuffer.get()+" ");
        }
        System.out.println();
        //检测对原始缓冲区进行修改，只读缓冲区可见
        buffer.put(2,(byte)20);
        readBuffer.flip();
        while(readBuffer.hasRemaining()){
            System.out.print(readBuffer.get()+" ");
        }
    }
}
