package java.calssloader.test;

/**
 * @program: java_performance_optimization
 * @Author:chenxuebing
 * @Date:2019-09-19 14:23
 * @Description:(描述)
 */

/**
 * 通过子类引用父类的静态字段，不会导致子类初始化
 */
public class SuperClass {
    static{
        System.out.println("SuperClass Init");
    }
    public static int value=123;
}
