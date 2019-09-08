package package3_5; /**
 * @ClassName A1019
 * @Description 1019. General Palindromic Number
 * @Author shishi
 * @Date 2019/8/12 15:42
 **/

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 输入：27 2
 * 输出：
 * Yes
 * 1 1 0 1 1
 *
 * 输入：121 5
 * 输出：
 * No
 * 4 4 1
 */
public class A1019 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int radix = scanner.nextInt();
        int[] radixArray = toRadixArray(number,radix);
        boolean flag = isPalindromic(radixArray);

        if (flag==true) System.out.println("Yes");
        else System.out.println("No");

        for (int i=0;i<radixArray.length;i++){
            if (i!=radixArray.length-1){
                System.out.print(radixArray[i]+" ");
            }else {
                System.out.print(radixArray[i]);
            }
        }

    }

    // 判断是否是回文
    private static boolean isPalindromic(int[] radixArray) {
        int length = radixArray.length;
        for (int i=0;i<length/2;i++){
            if (radixArray[i]!=radixArray[length-1-i]) return false;
        }
        return true;
    }

    // 将一个十进制的整数转换成对应radix进制的数组
    private static int[] toRadixArray(int number, int radix) {
        List<Integer> list = new ArrayList<>();
        while (number>0){
            int num = number%radix;
            number/=radix;
            list.add(num);
        }
        // list转换成数组
        int[] reversedRadxiArray = list.stream().mapToInt(Integer::intValue).toArray();
        int length = reversedRadxiArray.length;
        for (int i=0;i<length/2;i++){
            int temp = reversedRadxiArray[i];
            reversedRadxiArray[i] = reversedRadxiArray[length-1-i];
            reversedRadxiArray[length-1-i] = temp;
        }
        return reversedRadxiArray;
    }
}
