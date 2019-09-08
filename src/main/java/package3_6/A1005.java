package package3_6;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @ClassName A1005
 * @Description 1005. Spell It Right
 * @Author shishi
 * @Date 2019/8/8 10:32
 **/
public class A1005 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String next = scanner.next();
        // 将输入的字符串转换成char型的数组
        char[] chars = next.toCharArray();
        // 遍历char数组，将每一位的数字都加起来，得到一个总数（0需要特判）
        int sum = 0;
        for (int i=0;i<chars.length;i++){
            sum += chars[i]-'0';
        }
        // 根据总数来输入对应的字符串
        spell(sum);
    }

    // 15 -> one five
    private static void spell(int sum) {
        // 这个map存放的是0-9数字对应的英文
        Map<Integer, String> hashMap = new HashMap<>();
        hashMap.put(0,"zero");
        hashMap.put(1,"one");
        hashMap.put(2,"two");
        hashMap.put(3,"three");
        hashMap.put(4,"four");
        hashMap.put(5,"five");
        hashMap.put(6,"six");
        hashMap.put(7,"seven");
        hashMap.put(8,"eight");
        hashMap.put(9,"nine");

        // 0如果不特判的话，就会出错
        if (sum==0) System.out.println("zero");

        // 将这个sum按照每位数分割，存放到int数组中
        int[] nums = new int[2000];
        int index = 0;
        while (sum>0){
            nums[index++]=sum%10;
            sum/=10;
        }

        // 从后往前，根据每一位数字去map中找对应的英文输出，注意不要有多余的空格
        for (int i=index-1;i>=0;i--){
            if (i!=0) System.out.print(hashMap.get(nums[i])+" ");
            else System.out.print(hashMap.get(nums[i]));
        }
    }
}
