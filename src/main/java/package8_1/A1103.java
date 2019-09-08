package package8_1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @ClassName A1103
 * @Description 1103. Integer Factorization
 * @Author shishi
 * @Date 2019/9/1 18:25
 **/

/**
 * 题意：N = n[1]^P + ... n[K]^P
 * 169 5 2
 * 169 = 6^2 + 6^2 + 6^2 + 6^2 + 5^2
 */
public class A1103 {
    static int n,k,p;

    // 序列的底数之和
    static int maxFacSum = -1;

    // 存放结果序列
    static List ans = new ArrayList<Integer>();

    // 存放暂时的满足条件的结果序列（因为可能不止一组数据，看底数之和哪个最大）
    static List temp = new ArrayList<Integer>();

    // fac序列是用来所有index^p不大于n的index，以便于后面的枚举
    static List fac = new ArrayList<Integer>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        k = scanner.nextInt();
        p = scanner.nextInt();

        // 初始化fac序列
        init();

        // DFS，从fac的最后开始选择，这样保证先选到index大的
        DFS(fac.size()-1, 0, 0, 0);

        // 没有找到任何一个序列
        if (maxFacSum==-1) System.out.println("Impossible");
        else {
            System.out.print(n+" = "+ans.get(0)+"^"+p);
            for (int i=1;i<ans.size();i++){
                System.out.print(" + "+ans.get(i)+"^"+p);
            }
        }
    }

    // 重点——DFS
    // DFS(处理的fac数组中的第几位，当前已经选择了几个数，当前总和，当前选择的数的底数之和)
    // 因为题目中说“底数之和最大的”优先，所以为了让底数大的先被选中，递归从fac的最后面开始往前递归

    // 首先对当前的fac.get(index)开始，有“选”和“不选”两种选择。
    // 如果“不选”,则DFS（index-1,nowK,nowSum,facSum）
    // 如果“选”，因为没说底数不能重复，所以即使选了index，index仍然可以被选，所以DFS(index,nowK+1,nowSum+fac.get(index),facSum+index)
    private static void DFS(int index, int nowK, int nowSum, int facSum) {
        // 递归结束的条件，要么已经满足，要么已经不可能

        // 找到了满足条件的序列
        if (nowSum == n && nowK ==k){
            // 序列更优的话，就更新
            if (facSum>maxFacSum){
                // 把满足条件的temp赋给结果序列
                // 发现直接赋值的话，只是给了引用，并不是复制了
                // ans = temp;
                ans = new ArrayList<Integer>(temp);
                maxFacSum = facSum;
            }
            return;
        }

        // 如果总和已经超出n或者个数已经超出k，就退出
        if (nowSum>n || nowK>k){
            return;
        }

        // fac[0]不需要选择，所以从index为1开始
        if (index>=1){
            // 将底数index加入序列
            temp.add(index);
            // 有选和不选两种方案
            // “选”
            DFS(index,nowK+1,nowSum+(int)fac.get(index),facSum+index);
            // "选"结束之后把选的数字pop掉
            temp.remove(temp.size()-1);
            // "不选"
            DFS(index-1,nowK,nowSum,facSum);
        }
    }

    // init函数用来初始化fac数组，找到所有p次方不大于n的数，包括0
    private static void init() {
        int i=0;
        int temp=0;
        // 当i^p不大于n的时候，就把temp往fac中放
        while (temp<=n){
            fac.add(temp);
            temp = power(++i);
        }
    }

    // 计算x^p
    private static int power(int x) {
        int ans = 1;
        for (int i=0;i<p;i++){
            ans*=x;
        }
        return ans;
    }
}
