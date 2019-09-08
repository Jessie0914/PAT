package package4_2;

/**
 * @ClassName A1084
 * @Description 1084. Broken Keyboard
 * @Author shishi
 * @Date 2019/8/29 14:11
 **/

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * input: 7_This_is_a_test
 * output: _hs_s_a_es
 */
public class A1084 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String original_str = scanner.next();
        String actual_str = scanner.next();
        char[] original_arr = original_str.toCharArray();
        char[] actual_arr = actual_str.toCharArray();
        Set<Character> set = new HashSet<>();
        int i=0, j=0;
        for (;i<original_arr.length;i++){
            // 键没有坏
            if (j<actual_arr.length && original_arr[i]==actual_arr[j]){
                j++;
            }
            // 键坏掉了
            else {
                // 本来我是全部存储到hashset之后，最后输出的，但是发现顺序无法控制(后来发现其实可以用linkedHashSet)
                // 为了控制输出顺序，我就用了这个方法，一边保存一边输出
                int ori_size = set.size();
                set.add(Character.toUpperCase(original_arr[i]));
                int update_size = set.size();
                if (update_size == ori_size+1){
                    System.out.print(Character.toUpperCase(original_arr[i]));
                }
            }
        }
    }
}
