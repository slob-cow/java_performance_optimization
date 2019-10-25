import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @program: java_performance_optimization
 * @Author:chenxuebing
 * @Date:2019-09-23 16:26
 * @Description:(描述)
 */
public class Client3 {
    public static void main(String[] args) {
        ITicket ticket = TicketFactory.queryTicket("深圳北", "潮汕");
        ticket.showInfo("硬座");
        ticket = TicketFactory.queryTicket("深圳北", "潮汕");
        ticket.showInfo("软座");
        ticket = TicketFactory.queryTicket("深圳北", "潮汕");
        ticket.showInfo("硬卧");
    }

    interface ITicket {
        void showInfo(String bunk);
    }

    static class TrainTicket implements ITicket {
        private String from;
        private String to;
        private int price;

        public TrainTicket(String from, String to) {
            this.from = from;
            this.to = to;
        }

        @Override
        public void showInfo(String bunk) {
            this.price = new Random().nextInt(500);
            System.out.println(String.format("%s->%s：%s价格：%s 元", this.from, this.to, bunk, this.price));
        }
    }
    static class TicketFactory {
        private static Map<String, ITicket> sTicketPool = new ConcurrentHashMap<>();

        public static ITicket queryTicket(String from, String to) {
            String key = from + "->" + to;
            if (TicketFactory.sTicketPool.containsKey(key)) {
                System.out.println("使用缓存 ==> " + key);
                return TicketFactory.sTicketPool.get(key);
            }
            System.out.println("第一次查询，创建对象 ==> " + key);
            ITicket ticket = new TrainTicket(from, to);
            TicketFactory.sTicketPool.put(key, ticket);
            return ticket;
        }
    }
}
