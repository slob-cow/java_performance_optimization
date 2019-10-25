/**
 * @program: java_performance_optimization
 * @Author:chenxuebing
 * @Date:2019-09-23 16:42
 * @Description:(描述)
 */

/**
 * 模拟火车票查询伪代码
 */
public class SaleTicket {
    public static void main(String[] args) {
        /**
         * 创建目的地工厂
         */
        TicketIterface ticket = QueryTicketFactory.getTicket("深圳北", "潮汕");
        ticket.showInFo("软卧");
        TicketIterface ticket1 = QueryTicketFactory.getTicket("深圳北", "广州南");
        ticket1.showInFo("硬座");
    }
}
