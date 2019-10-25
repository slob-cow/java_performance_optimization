package com.test.java;

import java.nio.ByteBuffer;

/**
 * @program: java_performance_optimization
 * @Author:chenxuebing
 * @Date:2019-10-14 10:23
 * @Description:(描述)
 */
public class Duplicate_Buffer {
    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(15);
        for(int i = 0 ; i < 10 ; i++){
            buffer.put((byte)i);
        }
        //复制当前缓冲区
        ByteBuffer copyBuffer = buffer.duplicate();
        System.out.println("复制后的缓冲区");
        System.out.println(buffer);
        System.out.println(copyBuffer);
        //重置copyBuffer
        copyBuffer.flip();
        //重置copyBuffer后缓冲区变化
        System.out.println("重置copyBuffer后的缓冲区");
        System.out.println(buffer);
        System.out.println(copyBuffer);
        //向copyBuffer缓冲区中存入数据
        copyBuffer.put((byte)100);
        //buffer在相同的位置数据也发生了变化
        System.out.println("buffer.get(0) = "+buffer.get(0));
        System.out.println("copyBuffer.get(0) = "+ copyBuffer.get(0));
        buffer.slice();



    }
}
