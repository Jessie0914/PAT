package package3_1;

import java.util.Scanner;

/**
 * @ClassName A1046
 * @Description 1046. Shortest Distance
 * @Author shishi
 * @Date 2019/9/4 16:54
 **/

// 有一个case超时了，书上说要对dis数组和sum进行预处理就不会超时了，sum预处理很好想，dis数组预处理需要想一下
// 然后我照做了，还是超时了，哈哈，没办法，java的输入
public class A1046 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int[] distance = new int[number+1];
        int sum = 0;
        for (int i=1;i<=number;i++) {
            int dis = scanner.nextInt();
            sum += dis;
            distance[i] = sum;
        }

        int queryNum = scanner.nextInt();
        while (queryNum>0) {
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            if (start==end) {
                System.out.println("0");
                continue;
            }
            if (start>end) {
                int temp = start;
                start = end;
                end = temp;
            }

            // 真正开始处理距离，分别结算顺时针和逆时针
            int clockwiseDis;
            clockwiseDis = distance[end-1] - distance[start-1];

            int anticlockwiseDis;
            anticlockwiseDis = sum-clockwiseDis;

            if (clockwiseDis<anticlockwiseDis) {
                System.out.println(clockwiseDis);
            }else {
                System.out.println(anticlockwiseDis);
            }

            queryNum--;
        }
    }
}
