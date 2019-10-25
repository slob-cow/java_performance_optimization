package com.test.java;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @program: java_performance_optimization
 * @Author:chenxuebing
 * @Date:2019-10-13 10:01
 * @Description:(描述)
 */
public class Nio_Buffer_Copy {
    public static void main(String[] args) throws IOException {
        //输出流对象
        FileOutputStream fout = new FileOutputStream("d:/c.txt");
        //输入流对象
        FileInputStream fin = new FileInputStream("d:/a.txt");
        //输出流的通道，数据的目的地
        FileChannel writeChannel = fout.getChannel();
        //输入流的通道，数据的源头
        FileChannel readChannel = fin.getChannel();
        //Buffer对象
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        while(true){
            buffer.clear();
            System.out.println(buffer.position());
            int len = readChannel.read(buffer);
            if(len == -1){
                break;
            }
            System.out.println(buffer.position());
            buffer.flip();
            System.out.println(buffer.position());
            writeChannel.write(buffer);
            System.out.println(buffer.position());
        }
    }
}
