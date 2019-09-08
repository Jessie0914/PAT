package package3_3;
/**
 * @ClassName A1031
 * @Description 1031. Hello World for U
 * @Author shishi
 * @Date 2019/8/15 13:48
 **/

import java.util.Scanner;

/**
 * helloworld!
 */
public class A1031 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        char[] chars = s.toCharArray();
        int length = chars.length;
        int n1,n2,n3;
        n1 = n3 =  (length+2)/3;
        n2 = n1 + (length+2)%3;

        // 开始格式化输出
        // 先输出每一行只有一头一尾的n1-1行
        for (int i=0;i<n1-1;i++){
            System.out.print(chars[i]);
            // 输出n2-2个空格
            for (int j=0;j<n2-2;j++){
                System.out.print(" ");
            }
            System.out.println(chars[length-1-i]);
        }

        // 再输出最后一行
        for (int i=n1-1;i<n1+n2-1;i++){
            System.out.print(chars[i]);
        }
    }
}
