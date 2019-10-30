package com.test.java;

import java.awt.*;

/**
 * @program: java_performance_optimization
 * @Author:chenxuebing
 * @Date:2019-10-08 16:23
 * @Description:(描述)
 */
public class BufferMovingCircle extends NoBuffereMovingCircle {
    Graphics doubleBuffer = null; //缓冲区
    @Override
    public void init(){
        super.init();
        doubleBuffer = screenImage.getGraphics();
    }
    @Override
    public void paint(Graphics g){
        doubleBuffer.setColor(Color.white);
        doubleBuffer.fillRect( 0,0,200,100);
        drawCircle(doubleBuffer);
        g.drawImage(screenImage,0,0,this);
    }
}
