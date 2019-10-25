import java.calssloader.test.ConstantClass;
import java.calssloader.test.SuperClass;
import java.jdk.proxy.DBQuery;
import java.jdk.proxy.FactoryProxy;

/**
 * @program: java_performance_optimization
 * @Author:chenxuebing
 * @Date:2019-09-19 13:38
 * @Description:(描述)
 */

public class SubClass {

    public static void main(String[] args) {

        //通过代理工厂获取代理类
        FactoryProxy proxy = new FactoryProxy();
        //通过代理工厂在运行中生成代理对象完成指定的功能
        Object result = proxy.bind(new DBQuery());
        System.out.println(result);
    }
}