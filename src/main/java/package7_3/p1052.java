package package7_3;

import java.util.*;

/**
 * @ClassName p1052
 * @Description 1052. Linked List Sorting
 * @Author shishi
 * @Date 2019/8/16 19:59
 **/
public class p1052 {
    // 要考虑到的是无效结点的存在。。。。（坑人）
    // 超时永远无法解决，我没有办法了
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int beginAddr = scanner.nextInt();
        // 有效结点的个数
        int count = 0;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        Node_1052[] nodes = new Node_1052[100010];
        for (int i=0;i<number;i++){
            Node_1052 node = new Node_1052();
            int address =  scanner.nextInt();
            int key = scanner.nextInt();
            int next = scanner.nextInt();
            node.addr = address;
            node.key = key;
            node.next = next;
            nodes[address] = node;
        }

        // 遍历数组，找所有的有效结点，在这个过程再更新hashmap
        int p = beginAddr;
        while (p!=-1){
            count++;
            hashMap.put(p,nodes[p].key);
            p = nodes[p].next;
        }

        // 有可能存在所有的结点都是无效的情况，那么就直接输出"0 -1"即可
        if (count==0){
            System.out.println("0 -1");
            return;
        }

        // 根据key值排序
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(hashMap.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o1.getValue()-o2.getValue();
            }
        });

        // 先输出总数和head
        System.out.printf("%d %05d\n",count,list.get(0).getKey());

        // 然后按照顺序输出
        for (int i=0;i<list.size();i++){
            System.out.printf("%05d %d ",list.get(i).getKey(),list.get(i).getValue());
            if (i!=list.size()-1){
                System.out.printf("%05d\n",list.get(i+1).getKey());
            }
            // -1不能输出成-00001
            else System.out.println("-1");
        }
    }
}
