package com.test.java;

import java.nio.ByteBuffer;

/**
 * @program: java_performance_optimization
 * @Author:chenxuebing
 * @Date:2019-10-14 10:49
 * @Description:(描述)
 */
public class Slice_Buffer {
    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(15);
        for(int i = 0; i < 10; i++){
            buffer.put((byte)i);
        }
        buffer.position(2);
        buffer.limit(6);
        //生成2-6的缓冲区
        ByteBuffer subBuffer = buffer.slice();
        System.out.println(subBuffer);
        System.out.println(subBuffer.get(0));
        System.out.println(subBuffer.get(3));
        for(int i = 0; i < subBuffer.capacity(); i++){
            byte bb = subBuffer.get(i);
            bb*= 10;
            subBuffer.put(bb);
        }
        //重置父缓冲区，若不重置，输出20、30、40、50
        buffer.position(0);
        buffer.limit(buffer.capacity());
        while(buffer.hasRemaining()){
            System.out.print(buffer.get()+" ");
        }
        System.out.println();
    }
}
