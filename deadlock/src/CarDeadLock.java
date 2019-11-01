/**
 * author:chenxuebing
 * Date:2019/11/1
 * Time:15:59
 */

/**
 * 模拟死锁的情况：
 *   出现死锁的四个必要条件：
 *    1.互斥条件：一个资源同时只允许一个线程访问。
 *    2.请求与保持条件：一个线程请求其他资源失败，不会释放自己持有的资源。
 *    3.不可剥夺条件：进程所获得的资源，在未使用前都不可剥夺。
 *    4.循环等带条件：若干线程之间首尾相接的循环等待资源关系。
 */

import java.util.concurrent.locks.ReentrantLock;

/**
 * 构造汽车线程死锁问题
 *    四辆汽车请求资源，循环等待
 *
 *          北
 *      西      东
 *          南
 *
 *     情景：
 *         1.在北的汽车占有北的资源，请求向西的资源
 *         2.在西的汽车占有西的资源，请求向南的资源
 *         3.在南的汽车占有南的资源，请求向东的资源
 *         4.在东的汽车占有东的资源，请求向北的资源
 *
 *         此时，引发了循环等待的情况
 *
 */
public class CarDeadLock extends Thread{
    /**
     * 当前线程持有4把锁
     */
    private static ReentrantLock north = new ReentrantLock();
    private static ReentrantLock south = new ReentrantLock();
    private static ReentrantLock west = new ReentrantLock();
    private static ReentrantLock east = new ReentrantLock();

    /**
     * 汽车位置
     */
    private String direct;

    public CarDeadLock(String direct) {
        this.direct = direct;
    }

    @Override
    public void run() {
        //由北往西开的汽车，
        if(direct == "west"){
            //获取北资源的锁对象
            try {
                north.lockInterruptibly();
                try{
                    //模拟占有资源，对资源进行操作
                    Thread.sleep(500);
                    //试图获取向西的资源
                    west.lockInterruptibly();
                    System.out.println("car to west has pass");

                }finally {
                    //释放资源
                    //判断当前线程的持有锁情况
                    //如果当前线程持有north锁对象，就释放它
                    if(north.isHeldByCurrentThread()){
                        north.unlock();
                    }
                    //如果当前线程持有west锁对象，就释放它
                    if(west.isHeldByCurrentThread()){
                        west.unlock();
                    }
                }
            } catch (InterruptedException e) {
                System.out.println("car to west is kill");
            }
        }
        //由西往南开的汽车
        if(direct == "south"){
            try {
                //获取锁对象
                west.lockInterruptibly();
                //模拟占用资源
                try{
                    Thread.sleep(500);
                    //占有资源的同时请求资源
                    south.lockInterruptibly();
                    System.out.println("car to south has pass");
                }finally {
                    //判断当前线程所拥有的锁对象
                    if(west.isHeldByCurrentThread()){
                        west.unlock();
                    }
                    if(south.isHeldByCurrentThread()){
                        south.unlock();
                    }

                }

            } catch (InterruptedException e) {
                System.out.println("car to south is kill");
            }
        }
        //由南往东开的汽车
        if (direct == "east") {
            try {
                south.lockInterruptibly();
                //模拟使用资源，占用资源
                try{
                    Thread.sleep(500);
                    //占有资源的同时，请求资源
                    east.lockInterruptibly();
                }finally {
                    //判断当前线程所占有的资源
                    if(south.isHeldByCurrentThread()){
                        south.unlock();
                    }
                    if(east.isHeldByCurrentThread()){
                        east.unlock();
                    }
                }

            } catch (InterruptedException e) {
                System.out.println("car to east is kill");
            }
        }
        //由东开往北的汽车
        if(direct == "north"){
            //获取东位置资源
            try {
                east.lockInterruptibly();
                //模拟使用资源，占用资源
                try{
                    Thread.sleep(500);
                    //占有资源的同时，请求资源
                    north.lockInterruptibly();
                    System.out.println("car to north has pass");
                }finally {
                    if(east.isHeldByCurrentThread()){
                        east.unlock();
                    }
                    if(north.isHeldByCurrentThread()){
                        north.unlock();
                    }
                }
            } catch (InterruptedException e) {
                System.out.println("car to noth is kill");
            }
        }
    }
}
