package package9_4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @ClassName A1043
 * @Description 1043. Is It a Binary Search Tree
 * @Author shishi
 * @Date 2019/9/3 13:07
 **/
public class A1043 {
//    static TreeNode root;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        // 定义BST树的头结点
        TreeNode root = null;
        // 存放输入的原始序列
        List<Integer> original = new ArrayList<>();
        for (int i=0;i<n;i++){
            int val = scanner.nextInt();
            original.add(val);
            // 一边输入val，一边构建BST树
            insert(root,val);
        }

        // 求先序序列
        List pre = preOrder(root);

        // 求镜像的先序序列
        List mirrorPre = preMirrorOrder(root);

        // 求后序序列
        List post = postOrder(root);

        // 求镜像的后续序列
        List mirrorPost = postMirrorOrder(root);

        // 如果初始序列等于先序序列
        if (original==pre) {
            System.out.println("YES");
            // 然后输出后序序列
            for (int i=0;i<post.size();i++){
                if (i!=post.size()-1)
                    System.out.print(post.get(i)+" ");
                else
                    System.out.print(post.get(i));
            }
        }
        // 如果初始序列等于镜像先序序列
        else if (original==mirrorPre) {
            System.out.println("YES");
            // 然后输出镜像后序序列
            for (int i=0;i<mirrorPost.size();i++){
                if (i!=mirrorPost.size()-1)
                    System.out.print(mirrorPost.get(i)+" ");
                else
                    System.out.print(mirrorPost.get(i));
            }
        }
        else System.out.println("NO");
    }

    // 在正常后序遍历的时候，交换左右子树的遍历顺序即可
    private static List postMirrorOrder(TreeNode root) {
        List<Integer> mirrorPost = new ArrayList<>();

        if (root==null) return mirrorPost;
        List right = postMirrorOrder(root.right);
        mirrorPost.addAll(right);
        List left = postMirrorOrder(root.left);
        mirrorPost.addAll(left);
        mirrorPost.add(root.val);

        return mirrorPost;
    }

    // 求后序序列
    private static List postOrder(TreeNode root) {
        List<Integer> post = new ArrayList<>();

        if (root==null) return post;
        List left = postOrder(root.left);
        post.addAll(left);
        List right = postOrder(root.right);
        post.addAll(right);
        post.add(root.val);

        return post;
    }

    // 在正常先序遍历的时候，交换左右子树的遍历顺序即可
    private static List preMirrorOrder(TreeNode root) {
        List<Integer> mirrorPre = new ArrayList<>();
        if (root==null) return mirrorPre;

        mirrorPre.add(root.val);
        List right = preMirrorOrder(root.right);
        mirrorPre.addAll(right);
        List left = preMirrorOrder(root.left);
        mirrorPre.addAll(left);

        return mirrorPre;
    }

    // 先序序列
    private static List preOrder(TreeNode root) {
        List<Integer> pre = new ArrayList<>();
        if (root==null) return pre;

        pre.add(root.val);
        List left = preOrder(root.left);
        pre.addAll(left);
        List right = preOrder(root.right);
        pre.addAll(right);

        return pre;
    }

    // 构建BST树
    private static void insert(TreeNode root, int val) {
        // 找到空节点了，即为当前需要插入的位置
        if (root==null){
            root = new TreeNode();
            root.val = val;
            root.left = root.right = null;
            return;
        }

        // 如果比当前节点的值小，就插在左子树
        if (val<root.val) insert(root.left,val);
        // 否则，插在右子树
        else insert(root.right,val);
    }
}
