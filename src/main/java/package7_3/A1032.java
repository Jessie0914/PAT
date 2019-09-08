package package7_3;

import java.io.IOException;
import java.util.Scanner;

/**
 * @ClassName p1032
 * @Description 1032. Sharing
 * @Author shishi
 * @Date 2019/8/16 18:50
 **/
// 佛了，不管怎么样都是超时的，PAT对java真的是太不友好了。。。。。。。网上找一堆资料也是没啥好的解决办法，凭运气可能不超时GG
public class A1032 {
    public static void main(String[] args) throws IOException {
//        网上看到别人的定义输入的方法
//        Scanner sc = new Scanner(new BufferedInputStream(System.in));

        Scanner scanner = new Scanner(System.in);
        int beginAddrOfFirst = scanner.nextInt();
        int beginAddrOfSecond = scanner.nextInt();
        int numberOfWords = scanner.nextInt();
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
//        String[] s = bf.readLine().split(" ");
//        int beginAddrOfFirst = Integer.parseInt(s[0]);
//        int beginAddrOfSecond = Integer.parseInt(s[1]);
//        int numberOfWords = Integer.parseInt(s[2]);

        Node_1032[] nodes = new Node_1032[100010];
        // 录入所有结点的信息
        for (int i=0;i<numberOfWords;i++){
            Node_1032 node = new Node_1032();
            node.address = scanner.nextInt();
            node.data = scanner.next().charAt(0);
            node.next = scanner.nextInt();
//            String[] s1 = bf.readLine().split(" ");
//            node.address = Integer.parseInt(s1[0]);
//            node.data = s1[1].charAt(0);
//            node.next = Integer.parseInt(s1[2]);
            nodes[node.address] = node;
        }

//        bf.close();

//        HashSet<Integer> hashSet = new HashSet<>();
        int p1 = beginAddrOfFirst;
        // 将第一个单词所有的地址存下来
        while (p1!=-1){
            nodes[p1].flag = true;
//            hashSet.add(p1);
            p1 = nodes[p1].next;
        }

        int p2 = beginAddrOfSecond;
        while (p2!=-1){
//            if (hashSet.contains(p2)){
//                // 前面的数要用0补齐
//                System.out.printf("%05d",p2);
//                return;
//            }

//            网上也有人用其他方式格式化输出
//            DecimalFormat df = new DecimalFormat("00000");
//            System.out.println(df.format(p2));

            if (nodes[p2].flag==true){
                System.out.printf("%05d",p2);
                return;
            }
            p2 = nodes[p2].next;
        }

        // 找不到就输出-1
        System.out.println("-1");

    }
}

class Node_1032{
    int address, next;
    char data;
    boolean flag = false;

    public int getAddress() {
        return address;
    }

    public void setAddress(int address) {
        this.address = address;
    }

    public int getNext() {
        return next;
    }

    public void setNext(int next) {
        this.next = next;
    }

    public char getData() {
        return data;
    }

    public void setData(char data) {
        this.data = data;
    }
}

