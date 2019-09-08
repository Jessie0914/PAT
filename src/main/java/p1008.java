/**
 * @ClassName p1008
 * @Description 1008. Elevator
 * @Author shishi
 * @Date 2019/8/9 15:02
 **/

import java.util.Scanner;

/**
 * 上楼6s，下楼4s，停5s
 * 计算总时间
 *
 * 例子：
 * 3 2 3 1
 * 41
 */
public class p1008 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        int[] floors = new int[count];
        int index = 0;
        for (int i=0;i<count;i++){
            floors[index++] = scanner.nextInt();
        }

        int sumTime = 0;

        // 设置当前楼层为0层
        int curentFloor = 0;
        for (int i=0;i<floors.length;i++){
            int distance = floors[i]-curentFloor;
            if (distance>=0) {
                sumTime+=distance*6;
            }else {
                sumTime+=(-distance)*4;
            }
            sumTime+=5;
            // 更新“当前楼层”
            curentFloor = floors[i];
        }
        System.out.println(sumTime);
    }
}
