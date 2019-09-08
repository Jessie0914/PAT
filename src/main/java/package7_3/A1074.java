package package7_3;

import java.io.IOException;
import java.util.*;

/**
 * @ClassName A1074
 * @Description 1074. Reversing Linked List
 * @Author shishi
 * @Date 2019/8/16 14:30
 **/

// 太麻烦了，哭了
public class A1074 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int beginAddress = scanner.nextInt();
        int n = scanner.nextInt();
        int K = scanner.nextInt();
        Node[] nodes = new Node[100010];

        // 输入n个节点的信息
        for (int i=0;i<n;i++){
            // 不然会报空指针异常，要先new一个对象出来
            Node node = new Node();
            int address = scanner.nextInt();
            int data = scanner.nextInt();
            int nextAddress = scanner.nextInt();
            nodes[address] = node;
            nodes[address].address = address;
            nodes[address].data = data;
            nodes[address].next = nextAddress;
        }

        // 链表的头结点
        int p = beginAddress;
        // count表示有效结点的个数
        int count = 0;

        // 遍历链表，为了找所有的有效结点（有些结点不在以头结点为首的链表中）
        // 顺便赋值给order，从0开始
        while (p!=-1){
            nodes[p].order = count++;
            // 下一个结点
            p = nodes[p].next;
        }

        // 根据order，从小到大将链表排序
        // 注意！！！！如果数组中存在null的对象，排序会报空指针异常，所以先要过滤掉所有null的对象
        Node[] notNullNodes = filterNull(nodes);
        nodes = Arrays.copyOfRange(notNullNodes, 0, count);

        Arrays.sort(nodes, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.order-o2.order;
            }
        });

        // 有效结点即为前count个节点，所以为了后序方便，将count赋值给n
        n = count;

        // 以上的代码已经形成了一个单链表了，接下来格式化输出即可
        // 思想是分成n/k个完整的块数，可能会有一个有着n%k个节点的不完整的块
        // 前n/k-1个完整的块，从后往前输出即可，最后一个完整的块分成两种情况
        // ①后面没有不完整的块（n%k==0），那么最后一个节点要输出-1
        // ②后面有不完整的块（n%k!=0），那么不用做什么处理，去处理最后一个不完整的块就可以了

        // 枚举完整的n/k个块
        for (int i=0;i<n/K;i++){
            // 第i块倒着输出（只输出k-1个节点，最后一个结点要特殊处理）
            for (int j=(i+1)*K-1;j>i*K;j--){
                System.out.printf("%05d %d %05d\n",nodes[j].address,nodes[j].data,nodes[j-1].address);
            }
            // 然后是每一块的最后一个节点的next地址的处理
            // 先输出地址和数据
            System.out.printf("%05d %d ",nodes[i*K].address,nodes[i*K].data);

            // 然后处理最后一个结点
            // 如果不是最后一个完整块，就指向下一个块的最后一个结点
            if (i<n/K-1){
                System.out.printf("%05\n",nodes[(i+2)*K-1].address);
            }
            // 如果是最后一个完整块
            else {
                // 如果后面没有不完整的块了，就直接输出-1即可
                if (n%K==0)
                    System.out.println("-1");
                // 后面有不完整的块，输出不完整块的的第一个地址
                else {
                    System.out.printf("%05d\n",nodes[(i+1)*K].address);

                    // 剩下的不完整的块，那就直接正序输出
                    for (int q=n/K*K;q<n;q++){
                        System.out.printf("%05d %d ",nodes[q].address,nodes[q].data);
                        if (q!=n-1){
                            System.out.printf("%05d\n",nodes[q+1].address);
                        }else {
                            System.out.println("-1");
                        }
                    }

                }
            }
        }
    }

    private static Node[] filterNull(Node[] nodes) {
        int index = 0;
        Node[] notNullNodes = new Node[100010];
        for (int i=0;i<nodes.length;i++){
            if (nodes[i]!=null){
                Node node = new Node();
                node = nodes[i];
                notNullNodes[index++] = node;
            }
        }
        return notNullNodes;
    }

    /**
     * @ClassName Node
     * @Description TODO
     * @Author shishi
     * @Date 2019/8/16 18:59
     **/
    static class Node{
        int address, data, next;

        public int getOrder() {
            return order;
        }

        public void setOrder(int order) {
            this.order = order;
        }

        int order;

        public int getAddress() {
            return address;
        }

        public void setAddress(int address) {
            this.address = address;
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public int getNext() {
            return next;
        }

        public void setNext(int next) {
            this.next = next;
        }

        public Node() {
            this.order = Integer.MAX_VALUE;
        }
    }
}

