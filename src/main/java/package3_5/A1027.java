package package3_5; /**
 * @ClassName A1027
 * @Description 1027. Colors in Mars
 * @Author shishi
 * @Date 2019/8/12 20:51
 **/

import java.util.Scanner;

/**
 * 15 43 71
 * #123456
 * If a single color is only 1-digit long, you must print a 0 to its left.
 */
public class A1027 {
    // 这题比较简单，因为它规定了数字的大小，0~168，所以它转换成13进制后最多有2位
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int redDecimal = scanner.nextInt();
        int[] toRadixRedArray = toRadixValue(redDecimal);
        System.out.print("#");
        printf(toRadixRedArray);

        int greenDecimal = scanner.nextInt();
        int[] toRadixGreenArray = toRadixValue(greenDecimal);
        printf(toRadixGreenArray);

        int blueDecimal = scanner.nextInt();
        int[] toRadixBlueArray = toRadixValue(blueDecimal);
        printf(toRadixBlueArray);

    }

    private static void printf(int[] array) {
        char[] colors = new char[]{'0','1','2','3','4','5','6','7','8','9','A','B','C'};
        System.out.print(colors[array[0]]);
        System.out.print(colors[array[1]]);
    }

    private static int[] toRadixValue(int decimal) {
        int[] radixNums = new int[2];
        radixNums[0] = decimal/13;
        radixNums[1] = decimal%13;
        return radixNums;
    }
}
