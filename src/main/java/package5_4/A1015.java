package package5_4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @ClassName A1015
 * @Description 1015. Reversible Primes
 * @Author shishi
 * @Date 2019/8/12 13:19
 **/
public class A1015 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 不停接受用户的输入，直到输入负数break
        while (true){
            int number = scanner.nextInt();
            if (number<0) break;
            int radix = scanner.nextInt();

            // 先去判断本身是不是质数
            if (isPrime(number)==false) {
                System.out.println("No");
                continue;
            }

            // 将数据根据radix，反转成一个数组
            int[] reversedRadixArray = toRadixArray(number,radix);
            // 再根据反转后的数组，计算成一个十进制的数据
            int reverseDecimal = toDecimal(reversedRadixArray,radix);
            // 判断这个十进制的数据是不是质数即可
            if (isPrime(reverseDecimal)==true){
                System.out.println("Yes");
            }else {
                System.out.println("No");
            }
        }
    }

    // 根据int型数组和它的radix，计算它对应的十进制数据
    private static int toDecimal(int[] reversedRadixArray, int radix) {
        int sum =0;
        int length = reversedRadixArray.length;
        for (int i=0;i<length;i++){
            sum+=reversedRadixArray[i]*Math.pow(radix,length-1-i);
        }
        return sum;
    }

    // 将一个数根据radix，转换成一个int[]数组
    private static int[] toRadixArray(int number, int radix) {
        List<Integer> list = new ArrayList<>();
        while (number>0){
            int num = number%radix;
            number/=radix;
            list.add(num);
        }
        // 按顺序添加的话，其实就是反转后的数组
        // List转换成int[]
        return list.stream().mapToInt(Integer::valueOf).toArray();
    }

    // 判断一个数是否为素数的方法
    private static boolean isPrime(int n){
        if (n==1) return false;
        if (n==2) return true;
        // 如果是偶数，直接返回false
        if (n%2==0) return false;
        for (int i=3;i<=Math.sqrt(n)+1;i++){
            if (n%i==0) return false;
        }
        return true;
    }
}
