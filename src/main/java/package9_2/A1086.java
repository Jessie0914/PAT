package package9_2;

/**
 * @ClassName A1086
 * @Description 1086. Tree Traversals Again
 * @Author shishi
 * @Date 2019/9/2 15:27
 **/

import java.util.Scanner;
import java.util.Stack;

/**
 * 这题重要的是先要理解题意——“用栈来模拟树的遍历”
 * push的顺序其实就是前序遍历的顺序
 * pop的顺序其实就是中序遍历的顺序
 * 所以题目就转换成了“根据前序和中序序列重建一棵树，并且输出后序序列”
 */

public class A1086 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int preIndex = 0;
        int[] preOrder = new int[number];
        int inIndex = 0;
        int[] inOrder = new int[number];

        // 这个栈用来帮助完成inOrder序列的构造
        Stack<Integer> stack = new Stack<>();
        // 吃掉一个空行
        scanner.nextLine();

        // 一共会有number*2条输入
        for (int i=0;i<number*2;i++){
            String s = scanner.nextLine();
            String[] strings = s.split(" ");
            // 是前序数组里的
            if (strings[0].equals("Push")){
                preOrder[preIndex++] = Integer.parseInt(strings[1]);
                stack.add(Integer.parseInt(strings[1]));
            }else {
                inOrder[inIndex++] = stack.pop();
            }
        }

        // 根据前序和中序重建树
        TreeNode root = buildTree(inOrder, 0, inOrder.length, preOrder, 0, preOrder.length);

        // 最后根据root，输出后序序列
        // 额外传入了一个number的值，为了格式控制
        postTreversal(root,number);
    }

    // 用来控制格式输出
    static int index = 1;
    private static void postTreversal(TreeNode root,int number) {
        if (root==null) return;
        postTreversal(root.left,number);
        postTreversal(root.right,number);
        if (index!=number){
            System.out.print(root.val+" ");
            index++;
        }else {
            System.out.print(root.val);
        }
    }

    private static TreeNode buildTree(int[] inOrder, int begin1, int end1, int[] preOrder, int begin2, int end2) {
        if (begin1==end1) return null;
        if (begin2==end2) return null;

        TreeNode root = new TreeNode(preOrder[begin2]);
        int middle = findInoder(inOrder, begin1, end1, root.val);
        int leftSize = middle-begin1;
        root.left = buildTree(inOrder,begin1,middle,preOrder,begin2+1,begin2+1+leftSize);
        root.right = buildTree(inOrder,middle+1,end1,preOrder,begin2+1+leftSize,end2);

        return root;
    }

    private static int findInoder(int[] inOrder, int begin, int end, int val) {
        for (int i=begin;i<end;i++){
            if (inOrder[i]==val){
                return i;
            }
        }
        return -1;
    }
}
