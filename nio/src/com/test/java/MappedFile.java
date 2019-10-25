package com.test.java;

import java.io.*;
import java.nio.MappedByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.channels.FileChannel;

/**
 * @program: java_performance_optimization
 * @Author:chenxuebing
 * @Date:2019-10-14 11:38
 * @Description:(描述)
 */
public class MappedFile {
    public static void main(String[] args) throws IOException {
        RandomAccessFile fin = new RandomAccessFile("d:/a.txt","rw");
        FileChannel channel = fin.getChannel();
        MappedByteBuffer buffer = channel.map(FileChannel.MapMode.READ_WRITE, 0, 1024);
        while(buffer.hasRemaining()){
            System.out.print((char)buffer.get());
        }
    }
}
