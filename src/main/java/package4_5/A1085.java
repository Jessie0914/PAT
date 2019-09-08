package package4_5;

import java.util.Arrays;
import java.util.Scanner;
/**
 * @ClassName A1085
 * @Description 1085. Perfect Sequence
 * @Author shishi
 * @Date 2019/9/7 14:09
 **/
public class A1085 {
    // 这里有个坑点！！！就是数据单独都是int型的，但是相乘很有可能会超出int的范围，所以声明数组得声明成long的
    static long p;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        p = scanner.nextLong();

        long[] nums = new long[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextLong();
        }

        // 对于只有1个元素的数组特判
        if (n==1) {
            System.out.println("1");
            return;
        }

        // 对于有两个元素的数组特判
        if (n==2) {
            if (nums[1]<=nums[0]*p) {
                System.out.println("2");
                return;
            }else {
                System.out.println("1");
                return;
            }
        }

        // 先排好序
        Arrays.sort(nums);

        // 特殊情况，优化一下
        // 如果最大值都小于最小值*p，就说明所有的都满足，就直接输出整个数组长度即可
        if (nums[n-1]<=p*nums[0]) {
            System.out.println(n);
            return;
        }

        // 非特殊情况的处理方法如下
        int maxLength = Integer.MIN_VALUE;
        // 对于每一个nums[i]都往后找第一个不满足nums[j]<=nums[i]*p的j，这个过程可以用二分查找
        for (int i = 0; i < nums.length; i++) {
            long stardard = nums[i] * p;
            int index = findJ(nums,i+1,n-1,stardard);
            int length = index-i+1;
            if (length>maxLength) {
                maxLength = length;
            }
        }
        System.out.println(maxLength);
    }

    // 二分查找第一个不满足条件的j
    private static int findJ(long[] nums, int start, int end, Long stardard) {
        while (start<=end) {
            int middle = (start + end) / 2;
            // 如果当前已经超过了，就往左边找
            if (nums[middle]>stardard) {
                end = middle-1;
            }
            else {
                // 如果没有超过，并且下一个就超过，那么它就是想找的值
                if (middle+1<=end && nums[middle+1]>stardard) {
                    return middle;
                }
                // 如果已经是最后一个值了，那也是要找的
                else if(middle+1>end){
                    return middle;
                }
                else {
                    start = middle+1;
                }
            }
        }
        return -1;
    }
}

