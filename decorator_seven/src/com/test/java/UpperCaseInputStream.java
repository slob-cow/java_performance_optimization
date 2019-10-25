package com.test.java;

/**
 * @program: java_performance_optimization
 * @Author:chenxuebing
 * @Date:2019-09-26 9:47
 * @Description:(描述)
 */

/**
 * java的Io流机制就使用了装饰模式
 *    InputStream: 接口类
 *    FileInputStream: StringBufferInputStream: ByteArrayInPutStream : 被装饰类
 *    FilterInputStream: 装饰类接口
 *       --: 具体装饰类
 *           BufferInputStream: DateInputStream: LineNumberInputStream
 *
 */

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 实现一个将流中的小写字母转为大写字母的装饰者对象
 */
public class UpperCaseInputStream extends FilterInputStream {

    protected UpperCaseInputStream(InputStream in) {
        super(in);
    }

    @Override
    //读取流,将流中的小写字母转为大写字母
    public int read() throws IOException//单字符的读
    {
        int c=super.read();//这个super.read()就是调用上面super(in);的主题对象
        return c==-1?c:Character.toUpperCase((char)(c));
    }

    @Override
    public int read(byte[] b,int offset,int len) throws IOException//多字符的读
    {
        int result=super.read(b,offset,len);
        for(int i=0;i<result;i++)
        {
            b[i]=(byte)Character.toUpperCase((char)(b[i]));
        }
        return result;
    }
}
