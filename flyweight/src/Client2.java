import java.util.Random;

/**
 * @program: java_performance_optimization
 * @Author:chenxuebing
 * @Date:2019-09-23 16:24
 * @Description:(描述)
 */
class Client2 {
    public static void main(String[] args) {
        ITicket ticket = TicketFactory.queryTicket("深圳北", "潮汕");
        ticket.showInfo("硬座");
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
        public static ITicket queryTicket(String from, String to) {
            return new TrainTicket(from, to);
        }
    }
}
