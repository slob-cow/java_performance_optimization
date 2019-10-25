package com.test.java;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @program: java_performance_optimization
 * @Author:chenxuebing
 * @Date:2019-10-14 14:24
 * @Description:(描述)
 */
public class GatheringBuffer {
    public static void main(String[] args) throws IOException {
        //通过聚集创建文本文件，格式为 书名作者
        ByteBuffer bookBuf = ByteBuffer.wrap("java性能优化技巧".getBytes("utf-8"));
        ByteBuffer autBuf = ByteBuffer.wrap("葛一鸣".getBytes("utf-8"));
        int booklen = bookBuf.capacity();
        int autlen = autBuf.capacity();
        ByteBuffer[] buffer = new ByteBuffer[]{bookBuf ,autBuf};
        File file = new File("d:/gather.txt");
        //文件不存在时，创建一个新文件
        if(!file.exists()){
            file.createNewFile();
        }
        FileOutputStream fou = new FileOutputStream(file);
        FileChannel channel = fou.getChannel();
        //聚集写文件
        channel.write(buffer);
        channel.close();
        //通过散射读取文件，格式：书名作者
        //构造精确的Buffer
        ByteBuffer scatter_bookBuffer = ByteBuffer.allocate(booklen);
        ByteBuffer scatter_autBuffer = ByteBuffer.allocate(autlen);
        ByteBuffer[] scatter_Buffer = new ByteBuffer[]{scatter_bookBuffer, scatter_autBuffer};
        FileInputStream fin = new FileInputStream("d:/gather.txt");
        FileChannel fileChannel = fin.getChannel();
        fileChannel.read(scatter_Buffer);
        String bookName = new String(scatter_Buffer[0].array(),"utf-8");
        String authorName = new String(scatter_Buffer[1].array(),"utf-8");
        System.out.println(bookName+authorName);
    }
}
