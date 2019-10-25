package com.test.java;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FilterInputStream;
import java.io.IOException;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.Channel;
import java.nio.channels.FileChannel;

/**
 * @program: java_performance_optimization
 * @Author:chenxuebing
 * @Date:2019-10-13 9:08
 * @Description:(描述)
 */
public class Nio_Buffer_Channel {
    public static void main(String[] args) throws IOException {
        //获取一个输入流对象
        FileInputStream fin = new FileInputStream("d:/a.txt");
        //获取输入流对象的通道，作为数据的源头
        FileChannel fileChannel = fin.getChannel();
        //创建一个Buffer对象
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        //从通道中读取数据到Buffer中
        fileChannel.read(buffer);
        //关闭通道
        fileChannel.close();
        buffer.flip();
    }
}
