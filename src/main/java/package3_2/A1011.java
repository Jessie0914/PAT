package package3_2;
/**
 * @ClassName A1011
 * @Description 1011. World Cup Betting
 * @Author shishi
 * @Date 2019/8/11 23:35
 **/

import java.util.Scanner;

/**
 * W    T    L
 * 1.1  2.5  1.7
 * 1.2  3.1  1.6
 * 4.1  1.2  1.1
 *
 * 输出：T T W 39.31
 */

// 就是从三行中分别选出最大的，乘上0.65，再－1，最后乘2
public class A1011 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Double[][] teamOdds = new Double[3][3];
        for (int i=0;i<3;i++){
            for (int j=0;j<3;j++){
                teamOdds[i][j] = scanner.nextDouble();
            }
        }
        double maxProfit;
        double maxOdds = 1.0;
        for (int i=0;i<3;i++){
            double odds = 0.0;
            int team = 0;
            for (int j=0;j<3;j++){
                if (teamOdds[i][j]>odds){
                    odds = teamOdds[i][j];
                    team = j;
                }
            }
            maxOdds *= odds;
            if (team==0) System.out.print("W ");
            else if (team==1) System.out.print("T ");
            else System.out.print("L ");
        }

        maxProfit = (maxOdds*0.65-1)*2;
        System.out.printf("%.2f",maxProfit);
    }
}
