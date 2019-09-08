package package4_5; /**
 * @ClassName A1010
 * @Description 1010. Radix
 * @Author shishi
 * @Date 2019/8/11 15:03
 **/

import java.util.Scanner;

/**
 * 题目比较难理解
 * 输入：6 110 1 10 输出：2
 * 输入：1 ab 1 2 输出：Impossible
 */
public class A1010 {
    static boolean Impossible = true;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String first = scanner.next();
        char[] firstArray = first.toCharArray();
        String second = scanner.next();
        char[] secondArray = second.toCharArray();

        int tag = scanner.nextInt();
        // radix最大值为2^63-1
        long radix = scanner.nextLong();
        if (tag==1){
            long firstDecimal = caculate(firstArray,radix,Long.MAX_VALUE);
            cmp(0,Long.MAX_VALUE,firstDecimal,secondArray);
        }else {
            long secondDecimal = caculate(secondArray, radix,Long.MAX_VALUE);
            cmp(0,Long.MAX_VALUE,secondDecimal,firstArray);
        }
        if (Impossible==true) System.out.print("Impossible");
    }

    private static long caculate(char[] chars, long radix, long standardNum) {
        int sum = 0;
        int length = chars.length;
        for (int i=0;i<chars.length;i++){
            char currentChar = chars[i];
            int currentNum = 0;
            if(Character.isLetter(currentChar)){
                currentNum = currentChar-'a'+10;
            }else currentNum = currentChar-'0';
            sum += currentNum * Math.pow(radix,length-1-i);
            if (sum<0 || sum>standardNum) return -1;
        }
        return sum;
    }

    private static void cmp(long start,long end,long decimalNum,char[] chars){
        long mid;
        while (start<=end){
            mid = (start+end)/2;
            long caculateNum = caculate(chars, mid,decimalNum);
            if (caculateNum<0||caculateNum>decimalNum) end = mid;
            else if (caculateNum<decimalNum) start = mid;
            else {
                System.out.print(mid);
                Impossible = false;
                break;
            }
        }
    }
}
