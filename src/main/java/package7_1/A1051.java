package package7_1;

/**
 * @ClassName A1051
 * @Description 1051. Pop Sequence
 * @Author shishi
 * @Date 2019/8/29 21:43
 **/

import java.util.Scanner;
import java.util.Stack;

/**
 * 5 7 5
 * 1 2 3 4 5 6 7
 * 3 2 1 7 5 6 4
 * 7 6 5 4 3 2 1
 * 5 6 4 3 7 2 1
 * 1 7 6 5 4 3 2
 */
public class A1051 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // m为规定的栈的容量
        int m = scanner.nextInt();
        // n为序列的数量
        int n = scanner.nextInt();
        // k为要检测的个数
        int k = scanner.nextInt();

        for (int i=0;i<k;i++){
            // 每次都要初始化一个栈，不然会被上一个影响
            Stack<Integer> stack = new Stack<>();
            boolean flag = true;
            // 输入待测序列
            int[] nums = new int[n];
            for (int j=0;j<n;j++){
                nums[j] = scanner.nextInt();
            }

            // 按顺序推入n个数，在此期间保证容量没有超出m
            int p = 1;
            int j=0; // 数组的指针
            while (p<=n){
                // 先推入栈
                stack.add(p);
                p++;
                // 溢出，就直接退出
                if (stack.size()>m) {
                    flag = false;
                    break;
                }
                else {
                    // 栈不为空再去判断
                    if (!stack.isEmpty()){
                        // 如果栈顶部元素和数组头元素一样，就pop，用while()，并且也要判断是否为空
                        while (!stack.isEmpty() && stack.peek()==nums[j]){
                            stack.pop();
                            j++;
                        }
                    }
                }
            }
            // 如果最终栈为空并且没有溢出过
            if (stack.isEmpty() && flag) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}
