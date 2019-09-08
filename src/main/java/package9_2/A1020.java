package package9_2;

/**
 * @ClassName A1020
 * @Description 1020. Tree Traversals
 * @Author shishi
 * @Date 2019/9/2 13:41
 **/

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * input:
 * 7
 * 2 3 1 5 7 6 4
 * 1 2 3 4 5 6 7
 * output:
 * 4 1 6 3 5 7 2
 */
public class A1020 {
    public static void main(String[] args) {
        // 先根据中序和后序序列构造树
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();

        // 先输入后序序列数组
        int[] postOrder = new int[number];
        for (int i=0;i<number;i++){
            postOrder[i] = scanner.nextInt();
        }
        
        // 再输入中序序列
        int[] inorder = new int[number];
        for (int i=0;i<number;i++){
            inorder[i] = scanner.nextInt();
        }
        
        // 根据中序和后序序列，重建一颗树，用递归的方法
        // 这里有一个注意点：buildTree(inorder,0，中序序列长度，0，后序序列长度)
        // 一开始我想要用buildTree(inorder,0,length-1,postorder,0,length-1)
        // 但是后来发现总是越界……懒得找原因了，以后就记得用buildTree(inorder, 0, inorder.length, postOrder, 0, postOrder.length);就好了
        TreeNode root = buildTree(inorder, 0, inorder.length, postOrder, 0, postOrder.length);

        // 根据重建的树来输出levelOrder,用队列（层序遍历，用队列即可）
        Queue<TreeNode> queue = new LinkedList<>();
        // 先把根节点放入队列
        queue.offer(root);

        // 控制最后一个不要输出空格
        int index = 1;
        while (!queue.isEmpty()){
            if (index!=number) {
                System.out.print(queue.peek().val+" ");
                index++;
            }
            else
                System.out.print(queue.peek().val);
            TreeNode poll = queue.poll();
            if (poll.left!=null)
                queue.offer(poll.left);
            if (poll.right!=null)
                queue.offer(poll.right);
        }
    }

    // 重建树
    private static TreeNode buildTree(int[] inorder, int begin1, int end1, int[] postOrder, int begin2, int end2) {
        if (begin1==end1) return null;
        if (begin2==end2) return null;

        // 用postOrder最后一个构造root结点
        TreeNode root = new TreeNode(postOrder[end2-1]);

        // 在中序序列中找到对应的值
        int middle = findInoder(inorder, begin1, end1, root.val);
        int leftSize = middle-begin1;
        root.left = buildTree(inorder,begin1,middle,postOrder,begin2,begin2+leftSize);
        root.right = buildTree(inorder, middle + 1, end1, postOrder,begin2 + leftSize, end2-1);
        return root;
    }

    private static int findInoder(int[] inorder, int begin, int end, int val) {
        for (int i=begin;i<end;i++){
            if (inorder[i]==val){
                return i;
            }
        }
        return -1;
    }
}
