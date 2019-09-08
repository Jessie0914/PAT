package package4_2;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @ClassName A1041
 * @Description 1041. Be Unique
 * @Author shishi
 * @Date 2019/9/6 20:02
 **/

public class A1041 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        Map<Integer,Integer> map = new LinkedHashMap<Integer, Integer>();
        for (int i = 0; i < n; i++) {
            int cur = scanner.nextInt();
            if (map.containsKey(cur)) {
                int cur_num = map.get(cur);
                cur_num++;
                map.put(cur, cur_num);
            }else {
                map.put(cur, 1);
            }
        }

        boolean flag = false;
        // 遍历map，找第一个value=1的key输出即可
        Iterator<Integer> iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            int cur = (int) iterator.next();
            if (map.get(cur)==1) {
                System.out.println(cur);
                flag = true;
                return;
            }
        }

        if (!flag) {
            System.out.println("None");
        }
    }
}

