package package4_4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * @ClassName A1037
 * @Description 1037. Magic Coupon
 * @Author shishi
 * @Date 2019/9/6 20:49
 **/
public class A1037 {

    // 贪心思想：将数组分成正的数组，负的数组
    // 正的数组从大到小排列，负的数组从小到大排列
    // 然后分别从前往后，各取一个元素相乘，只要一个数组到达了边界就停止
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> firstPositiveList = new ArrayList<Integer>();
        List<Integer> firstNegativeList = new ArrayList<Integer>();
        List<Integer> secondPositiveList = new ArrayList<Integer>();
        List<Integer> secondNegativeList = new ArrayList<Integer>();

        // 第一个数组，分成正负两个数组
        int fir_num = scanner.nextInt();
        for (int i = 0; i < fir_num; i++) {
            int num = scanner.nextInt();
            if (num>0) {
                firstPositiveList.add(num);
            } else if (num<0) {
                firstNegativeList.add(num);
            }
        }

        // 第二个数组，分成正负两个数组
        int sec_num = scanner.nextInt();
        for (int i = 0; i < sec_num; i++) {
            int num = scanner.nextInt();
            if (num>0) {
                secondPositiveList.add(num);
            } else if (num<0) {
                secondNegativeList.add(num);
            }
        }

        // 正数从大到小排序
        Object[] firstPositiveArray = firstPositiveList.toArray();
        Object[] secondPositiveArray = secondPositiveList.toArray();

        Arrays.sort(firstPositiveArray, new Comparator<Object>() {
            @Override
            public int compare(Object o1, Object o2){
                return (int)o2-(int)o1;
            }
        });

        Arrays.sort(secondPositiveArray, new Comparator<Object>() {
            @Override
            public int compare(Object o1, Object o2){
                return (int)o2-(int)o1;
            }
        });

        // 负数从小到大排序
        Object[] firstNegativeArray = firstNegativeList.toArray();
        Object[] secondNegativeArray = secondNegativeList.toArray();

        Arrays.sort(firstNegativeArray);
        Arrays.sort(secondNegativeArray);

        //
        int sum = 0;
        int i=0;
        while (i<firstPositiveArray.length && i<secondPositiveArray.length) {
            sum += (int)firstPositiveArray[i] * (int)secondPositiveArray[i];
            i++;
        }

        int j=0;
        while (j<firstNegativeArray.length && j<secondNegativeArray.length) {
            sum += (int) firstNegativeArray[j] * (int) secondNegativeArray[j];
            j++;
        }

        System.out.println(sum);
    }
}

