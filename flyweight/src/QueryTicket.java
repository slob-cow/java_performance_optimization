/**
 * @program: java_performance_optimization
 * @Author:chenxuebing
 * @Date:2019-09-23 16:45
 * @Description:(描述)
 */

import java.util.Random;

/**
 * 提供给用户的一个查询接口，根据用户输入的出发地和目的地打印车票信息
 */
public class QueryTicket implements TicketIterface{
    private String from;
    private String to;
    private int price;
    QueryTicket(String from, String to){
        this.from = from;
        this.to = to;
    }
    @Override
    public void showInFo(String bunk) {
        this.price = new Random().nextInt(500);
        System.out.println(String.format("%s->%s：%s价格：%s 元", this.from, this.to, bunk, this.price));
    }
}
