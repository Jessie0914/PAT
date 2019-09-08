package package7_3;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

/**
 * @ClassName p1097
 * @Description 1097. Deduplication on a Linked List
 * @Author shishi
 * @Date 2019/8/17 9:29
 **/
public class A1097 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int beginAddr = scanner.nextInt();
        int number = scanner.nextInt();
        Node_1097[] nodes = new Node_1097[100010];
        for (int i=0;i<number;i++){
            Node_1097 node = new Node_1097();
            int address = scanner.nextInt();
            int key = scanner.nextInt();
            int next = scanner.nextInt();
            node.address = address;
            node.key = key;
            node.next = next;
            nodes[address] = node;
        }

        Map<Integer, Integer> deduplicationMap = new HashMap<>();
        Map<Integer, Integer> removedMap = new HashMap<>();
        int count = 0;
        int p = beginAddr;
        while (p!=-1){
            count++;
            int key = nodes[p].key;
            // 如果是重复元素
            if (deduplicationMap.containsValue(Math.abs(key))||deduplicationMap.containsValue(-Math.abs(key))){
                removedMap.put(p,key);
            }else {
                deduplicationMap.put(p,key);
            }
            p = nodes[p].next;
        }

        // 保留元素和删除链表都为空
        if (count==0){
            System.out.println("-1");
            System.out.println("-1");
        }

        // 先输出无重复的保留链表
        Iterator<Integer> iterator = deduplicationMap.keySet().iterator();
        int preAddr = iterator.next();//100
        int index1 = 0;
        for (int i=0;i<deduplicationMap.size();i++){
            if (index1!=deduplicationMap.size()-1){
                System.out.printf("%05d %d ",preAddr,deduplicationMap.get(preAddr));
                int next = iterator.next();
                System.out.printf("%05d\n",next);
                preAddr = next;
            }else {
                System.out.printf("%05d %d ",preAddr,deduplicationMap.get(preAddr));
                System.out.println("-1");
            }
            index1++;
        }

        // 再输出removedList
        Iterator<Integer> iterator1 = removedMap.keySet().iterator();
        int preRemovedAddr = iterator1.next();
        int index2 = 0;
        for (int i=0;i<removedMap.size();i++){
            if (index2!=removedMap.size()-1){
                System.out.printf("%05d %d ",preRemovedAddr,removedMap.get(preRemovedAddr));
                int next = iterator1.next();
                System.out.printf("%05d\n",next);
                preRemovedAddr = next;
            }else {
                System.out.printf("%05d %d ",preRemovedAddr,removedMap.get(preRemovedAddr));
                System.out.println("-1");
            }
            index2++;
        }
    }
}

class Node_1097{
    int address,key,next;

    public int getAddress() {
        return address;
    }

    public void setAddress(int address) {
        this.address = address;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public int getNext() {
        return next;
    }

    public void setNext(int next) {
        this.next = next;
    }
}
