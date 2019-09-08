package package9_2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @ClassName A1102
 * @Description 1102. Invert a Binary Tree
 * @Author shishi
 * @Date 2019/9/2 16:48
 **/

// 这里要用到的是二叉树的静态写法，记录左右子树的时候，只记编号
public class A1102 {
    static boolean[] notRoot = new boolean[110];
    // 结点个数
    static int number;
    static StaticTreeNode[] nodes = new StaticTreeNode[110];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        number = scanner.nextInt();
        // 获取输入，填充notRoot数组以及nodes数组
        for (int i=0;i<number;i++){
            nodes[i] = new StaticTreeNode();
            // 左节点
            char[] chars1 = scanner.next().toCharArray();
            nodes[i].left = charToNum(chars1[0]);
            // 右结点
            char[] chars2 = scanner.next().toCharArray();
            nodes[i].right = charToNum(chars2[0]);
        }

        // 寻找根节点
        int root = findRoot();

        // 通过后序遍历反转二叉树（重要知识点）
        postTraverse(root);
        
        // 输出反转后的二叉树的层序遍历
        levelTraverse(root);
        System.out.println();

        // 输出反转后的二叉树的中序遍历
        inOrder(root);
    }

    static int index2 = 0;
    private static void inOrder(int root) {
        if (root==-1) return;

        inOrder(nodes[root].left);
        if (index2!=number-1){
            System.out.print(root+" ");
            index2++;
        }else {
            System.out.print(root);
        }
        inOrder(nodes[root].right);
    }

    static int index1 = 0;
    private static void levelTraverse(int root) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()){
            int peek = queue.peek();
            if (index1!=number-1){
                System.out.print(peek+" ");
                index1++;
            }else {
                System.out.print(peek);
            }

            int pop = queue.poll();
            if (nodes[pop].left!=-1){
                queue.offer(nodes[pop].left);
            }
            if (nodes[pop].right!=-1){
                queue.offer(nodes[pop].right);
            }
        }
    }

    // 反转树的时候，用到的是后序遍历
    // 在后序遍历访问根节点的时候交换left和right
    private static void postTraverse(int root) {
        if (root==-1) return;
        postTraverse(nodes[root].left);
        postTraverse(nodes[root].right);

        // 交换左右子树
        int temp = nodes[root].left;
        nodes[root].left = nodes[root].right;
        nodes[root].right = temp;
    }

    // 遍历notRoot数组，找到值为false的那个
    private static int findRoot() {
        for (int i=0;i<number;i++){
            if (!notRoot[i]){
                return i;
            }
        }
        return -1;
    }

    // 顺带填充notRoot数组
    private static int charToNum(char c) {
        if (c=='-') return -1;
        else {
            // 记为“非根节点”
            notRoot[c-'0'] = true;
            return c-'0';
        }
    }
}

class StaticTreeNode{
    int left;
    int right;

    public void setLeft(int left) {
        this.left = left;
    }

    public void setRight(int right) {
        this.right = right;
    }
}
