/**
 * author:chenxuebing
 * Date:2019/11/1
 * Time:16:54
 */

/**
 * 测试汽车死锁情况
 */
public class CarDeadLockTest {
    public static void main(String[] args) throws InterruptedException {
        //构建四辆开往不同方向的汽车，模拟请求资源阻塞，占有资源不放的循环等待现象。
        //汽车由 北 ---> 西，占有北的资源，请求向西的资源
        CarDeadLock carToWest = new CarDeadLock("west");
        //汽车由 西 ---> 南，占有西的资源，请求向南的资源
        CarDeadLock carToSouth = new CarDeadLock("south");
        //汽车由 南 ---> 东，占有南的资源，请求向东的资源
        CarDeadLock carToEast = new CarDeadLock("east");
        //汽车由 东 ---> 北，占有东的资源，请求向北的资源
        CarDeadLock carToNorth = new CarDeadLock("north");

        //开启线程
        carToWest.start();
        carToSouth.start();
        carToEast.start();
        carToNorth.start();
        //Thread.sleep(1000);
        //中断线程，破会死锁条件，强行剥夺资源
        //carToNorth.interrupt();
    }
    //使用JDK自带的jconsole图形化工具来检测死锁
}
