package com.test.java;

import java.nio.ByteBuffer;

/**
 * @program: java_performance_optimization
 * @Author:chenxuebing
 * @Date:2019-10-14 8:51
 * @Description:(描述)
 */
public class BufferTest {
    public static void main(String[] args) {
        byte array[] = new byte[1024];
        ByteBuffer buffer = ByteBuffer.wrap(array);
       /* //返回当前position的数据，position后移一位
        public byte get();
        //读取Buffer的数据到dst,并恰当的移动position
        public ByteBuffer get(byte[] dst);
        //读取给定index上的数据，不改变position的位置
        public byte get(int index);
        //在当前位置写入给定数据，position后移一位
        public ByteBuffer put(byte b);
        //将当前数据写入index位置
        public ByteBuffer put(int index, byte b);
        //将给定的数据src写入到Buffer中
        public final ByteBuffer put(byte[] src);*/
        byte[] v = new byte[3];
        buffer.put(1,(byte)'j');
        buffer.put(v);
        System.out.println(buffer.position());
        buffer.mark();
        buffer.reset();
    }
}
