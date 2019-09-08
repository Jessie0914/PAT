package package5_1;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @ClassName A1069
 * @Description 1069. The Black Hole of Numbers
 * @Author shishi
 * @Date 2019/9/7 18:23
 **/

public class A1069 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String num = scanner.next();
        char[] numChars = num.toCharArray();

        // 表示这个数是不是4位都一样，默认初试为true，只要一找到一个不一样的，就置为false，然后跳出循环
        boolean flag = true;
        char c = numChars[0];
        for (int i = 1; i < 4; i++) {
            if (numChars[i]!=c) {
                flag = false;
                break;
            }
        }
        // 如果flag仍然为true，那么就直接输出
        if (flag) {
            System.out.println(num + " - " + num + " = 0000");
        }
        // 接下来是普通数字的处理方法
        else {
            // 只要当前的数字不是6174就一直循环下去
            while (!num.equals("6174")) {
                numChars = num.toCharArray();
                // 然后将当前的数字升序排列
                Arrays.sort(numChars);
                String minValueString = String.valueOf(numChars);
                int minValue = Integer.parseInt(minValueString);

                // 然后将数字降序排列（这里要注意，char[]型数组没办法自定义排列，只能转换成Character[]数组再排序）
                int maxValue = 0;
                for (int i = numChars.length-1; i >=0 ; i--) {
                    maxValue = maxValue*10+(numChars[i]-'0');
                }

                int minus = maxValue-minValue;
                System.out.printf("%04d - %04d = %04d\n",maxValue,minValue,minus);
                num = String.valueOf(minus);
            }
        }
    }

}

