package package11_2;

/**
 * @ClassName A1007
 * @Description 1007. Maximum Subsequence Sum
 * @Author shishi
 * @Date 2019/9/3 15:49
 **/

import java.util.Arrays;
import java.util.Scanner;

/**
 * 算是基础的动态规划题（做过几次了，但还是一直在忘）
 */
public class A1007 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];

        // 记录所有的数是否全是负数
        boolean isAllNegative = false;

        for (int i=0;i<n;i++){
            int num = scanner.nextInt();
            nums[i] = num;
            // 这里是要大于等于0，不然有一个case不过
            if (num>=0) isAllNegative = true;
        }

        // 如果全是负的，就直接输出0以及首位元素
        if (!isAllNegative) {
            System.out.println("0"+" "+nums[0]+" "+nums[n-1]);
            return;
        }

        // 动态规划
        // dp[i]记录的是以i结尾的最大子序列和，边界值dp[0]需要初始化为nums[0]
        int[] dp = new int[n];
        dp[0] = nums[0];

        // s[i]记录的是从哪个元素开始到i为最大子序列和，初始化为0
        int[] s = new int[n];
        Arrays.fill(s,0);

        for (int i=1;i<n;i++){
            // 如果加上dp[i-1]是"锦上添花"的话，就加上去
            // 并且更新dp(为加上了dp[i]的值)
            // 更新s（和s[i-1]一样，因为在原序列的基础上加上了nums[i]）
            // 因为题意中表示如果有多种结果的时候，选那个i.j小的那个，所以这里不是"dp[i-1]+nums[i]>=dp[i-1]"
            if (nums[i]+dp[i-1]>nums[i]){
                dp[i] = dp[i-1]+nums[i];
                s[i] = s[i-1];
            }
            // 如果加上以后"雪上加霜"的话，那么dp[i]就独立成军
            // s[i]也更新为i，因为独立成军重新从i开始了
            else {
                dp[i] = nums[i];
                s[i] = i;
            }
        }

        // 结束以后，dp[i]数组中存放了所有以i结束的局部最大子序列和
        // 所以要遍历dp数组，来找出所有"局部最大子序列和"中的"全局最大子序列和"
        // maxDp为"全局最大子序列和"，endIndex为"最大子序列和结束的下标"
        int endIndex = 0;
        for (int i=1;i<n;i++){
            if (dp[i]>dp[endIndex]){
                endIndex = i;
            }
        }

        System.out.println(dp[endIndex]+" "+nums[s[endIndex]]+" "+nums[endIndex]);
    }
}
