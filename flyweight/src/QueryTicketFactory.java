/**
 * @program: java_performance_optimization
 * @Author:chenxuebing
 * @Date:2019-09-23 16:57
 * @Description:(描述)
 */
public class QueryTicketFactory {
    public static TicketIterface getTicket(String from, String to){
        return new QueryTicket(from, to);
    }
}
