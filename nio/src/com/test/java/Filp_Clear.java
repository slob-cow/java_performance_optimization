package com.test.java;

import java.nio.ByteBuffer;

/**
 * @program: java_performance_optimization
 * @Author:chenxuebing
 * @Date:2019-10-13 10:58
 * @Description:(描述)
 */
public class Filp_Clear {
    public static void main(String[] args) {
        //创建具有15个字节的Buffer对象
        ByteBuffer buffer = ByteBuffer.allocate(15);
        System.out.println("存入元素后position和limit的变化==>"+"position:"+buffer.position()+" limit:"+buffer.limit()+" capacity:" +buffer.capacity());
        //向Buffer中存入数据
        for(int i = 0 ; i < 10 ; i++){
            buffer.put((byte)i);
        }
        //存入元素后position和limit的变化
        System.out.println("存入元素后position和limit的变化==>"+"position:"+buffer.position()+" limit:"+buffer.limit()+" capacity:" +buffer.capacity());
        buffer.flip();
        //flip后position和limit的变化
        System.out.println("flip后position和limit的变化==>"+"position:"+buffer.position()+" limit:"+buffer.limit()+" capacity:" +buffer.capacity());
        for(int i = 0 ; i < 5 ; i++){
            System.out.print(buffer.get()+" ");
        }
        System.out.println();
        //读取Buffer元素后position和limit的变化
        System.out.println("读取Buffer元素后position和limit的变化==>"+"position:"+buffer.position()+" limit:"+buffer.limit()+" capacity:" +buffer.capacity());
        buffer.rewind();
        System.out.println("rewind==>"+"position:"+buffer.position()+" limit:"+buffer.limit()+" capacity:" +buffer.capacity());
        buffer.flip();
        //第二次flip后position和limit的变化
        System.out.println("第二次flip后position和limit的变化==>"+"position:"+buffer.position()+" limit:"+buffer.limit()+" capacity:" +buffer.capacity());
        buffer.clear();
        //clear后position和limit的变化
        System.out.println("clear后position和limit的变化==>"+"position:"+buffer.position()+" limit:"+buffer.limit()+" capacity:" +buffer.capacity());

    }
}
