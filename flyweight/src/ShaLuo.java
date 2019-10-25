import java.util.Scanner;

/**
 * @program: java_performance_optimization
 * @Author:chenxuebing
 * @Date:2019-09-23 20:03
 * @Description:(描述)
 */
public class ShaLuo {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String input = s.next();
        String[] split = input.split(" ");
        //
        String star = split[1];
        String num = split[0];
        int n = new Integer(num);
        while(true){
            for(int i = 0 ; i < n-1 ; i++ ){
                System.out.print(" ");
            }
        }

    }
}
