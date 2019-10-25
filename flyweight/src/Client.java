import java.util.HashMap;
import java.util.Map;

/**
 * @program: java_performance_optimization
 * @Author:chenxuebing
 * @Date:2019-09-23 15:37
 * @Description:(描述)
 */
class Client {
    public static void main(String[] args) {
        IFlyweight flyweight1 = FlyweightFactory.getFlyweight("aa");
        IFlyweight flyweight2 = FlyweightFactory.getFlyweight("bb");
        flyweight1.operation("a");
        flyweight2.operation("b");
    }

    // 抽象享元角色
    interface IFlyweight {
        void operation(String extrinsicState);
    }

    // 具体享元角色
    static class ConcreteFlyweight implements IFlyweight {
        private String intrinsicState;

        public ConcreteFlyweight(String intrinsicState) {
            this.intrinsicState = intrinsicState;
        }

        @Override
        public void operation(String extrinsicState) {
            System.out.println("Object address: " + System.identityHashCode(this));
            System.out.println("IntrinsicState: " + this.intrinsicState);
            System.out.println("ExtrinsicState: " + extrinsicState);
        }
    }

    // 享元工厂
    static class FlyweightFactory {
        private static Map<String, IFlyweight> pool = new HashMap<>();

        // 因为内部状态具备不变性，因此作为缓存的键
        public static IFlyweight getFlyweight(String intrinsicState) {
            if (!pool.containsKey(intrinsicState)) {
                IFlyweight flyweight = new ConcreteFlyweight(intrinsicState);
                pool.put(intrinsicState, flyweight);
            }
            return pool.get(intrinsicState);
        }
    }
}
