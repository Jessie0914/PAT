package package4_2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @ClassName A1092
 * @Description 1092. To Buy or Not to Buy
 * @Author shishi
 * @Date 2019/9/6 17:31
 **/

public class A1092 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String shop_str = scanner.next();
        String like_str = scanner.next();

        Map<Character,Integer> hashMap = new HashMap<Character, Integer>();

        // 遍历店主的珠子
        for (int i = 0; i < shop_str.length(); i++) {
            Character cur_c = shop_str.charAt(i);
            // 如果本身就有这个颜色了
            if (hashMap.containsKey(cur_c)) {
                int num = hashMap.get(cur_c);
                num = num+1;
                hashMap.put(cur_c, num);
            }else {
                hashMap.put(cur_c, 1);
            }
        }

        boolean flag = true;
        int lackNum = 0;
        // 遍历自己的珠子，去找有没有缺失的颜色
        for (int i = 0; i < like_str.length(); i++) {
            char cur_c = like_str.charAt(i);
            // 如果没有
            if (!hashMap.containsKey(cur_c)) {
                flag = false;
                lackNum++;
            }
            // 如果有，也要看数量是否满足
            else {
                int cur_num = hashMap.get(cur_c);
                if (cur_num>0) {
                    cur_num--;
                    hashMap.put(cur_c, cur_num);
                }else {
                    lackNum++;
                    // 这个不要忘记了！！！
                    flag = false;
                }
            }
        }

        // 输出
        if (flag) {
            System.out.print("Yes ");
            System.out.println(shop_str.length()-like_str.length());
        }else {
            System.out.println("No " + lackNum);
        }
    }

}
