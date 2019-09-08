package package9_3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @ClassName A1079
 * @Description 1079. Total Sales of Supply Chain
 * @Author shishi
 * @Date 2019/9/2 20:09
 **/

/**
 * 这是树的遍历（不一定是二叉树，所以存放子节点的时候，不能只有left、right，而是需要一个list）
 */
public class A1079 {
    static Node[] nodes = new Node[100010];
    static double p;
    static double r;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        p = scanner.nextDouble();
        r = scanner.nextDouble();
        // 将提价百分比换算成小数
        r /= 100;

        for (int i=0;i<number;i++){
            nodes[i] = new Node();
            int k = scanner.nextInt();
            // k==0说明这是叶节点（子节点个数为0），接下来输入的数，是货物的量，而不是子节点的编号
            if (k==0){
                nodes[i].val = scanner.nextInt();
            }
            // 不是叶节点，输入的是子节点的编号
            else {
                List<Object> list = new ArrayList<>();
                for (int j=0;j<k;j++){
                    int child = scanner.nextInt();
                    list.add(child);
                }
                nodes[i].child = list;
            }
        }

        // DFS和BFS都可以，如果用DFS，需要传入两个参数
        // 一个是当前处理的结点index，另一个是深度depth
        DFS(0,0);

        System.out.printf("%.1f\n",p * ans);
    }

    static double ans = 0.0;
    private static void DFS(int index, int depth) {
        // 递归边界是：当访问到的结点的子节点个数为0，即当前为叶子节点时，就把ans加上 货物*提价的价格
        if (nodes[index].child==null){
            ans += nodes[index].val * Math.pow(1+r,depth);
            return;
        }

        // 没有到递归边界，就依次遍历当前节点的每个子节点
        for (int i=0;i<nodes[index].child.size();i++){
            DFS((int)nodes[index].child.get(i),depth+1);
        }
    }
}

class Node{
    double val;
    List child;
}
