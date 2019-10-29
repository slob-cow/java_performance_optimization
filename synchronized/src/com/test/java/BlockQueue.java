package com.test.java;

/**
 * @author yangchao
 * @date 2019/10/28.
 * @description
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 使用synchronize和wait(), notify()实现一个阻塞队列
 * 实现：
 *    获取队列中的元素: 使用pop操作队列，当队列中有元素，则取出第一个元素，若队列为空，线程进入等待状态
 *    使用put()方法添加元素，并唤醒等待的线程
 */
public class BlockQueue {
    List list = new ArrayList<>();
    public synchronized Object pop() throws InterruptedException {
        //当涉及条件判断时，wait方法要在一个循环中使用，并指出跳出循环的条件
        //原因：若使用if语句，线程被唤醒，直接执行接下的业务逻辑，不再进行list.size() == 0的判断，若之前队列的
        //元素被消费，此时又再次唤醒该线程，队列中无数据，执行业务逻辑出错。
        //将wait()放入while中，唤醒线程后会再次进行条件判断，条件满足则执行业务逻辑。
        if(list.size() == 0) {
            this.wait();
        }
        if(list.size() > 0){
            System.out.println("取值");
            return list.remove(0);
        }else{
            return null;
        }
    }

    public synchronized void put(Object obj){
        list.add(obj);
        this.notify();
    }
}
