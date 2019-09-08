package package3_6;

/**
 * @ClassName A1082
 * @Description 1082. Read Number in Chinese
 * @Author shishi
 * @Date 2019/9/5 20:17
 **/

import java.util.Scanner;

/**
 * -123456789
 * Fu yi Yi er Qian san Bai si Shi wu Wan liu Qian qi Bai ba Shi jiu
 */
public class A1082 {
    // 这道题我不会啊！！脑回路转不过来，第二天再看下吧，觉得好难
    static String[] num = {"ling","yi","er","san","si","wu","liu","qi","ba","jiu"};
    static String[] wei = {"Shi","Bai","Qian","Wan","Yi"};
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        int length = s.length();
        // left和right分别指向首尾元素
        int left = 0;
        int right = length-1;

        if (s.charAt(0)=='-'){
            System.out.print("Fu");
            left++;
        }

        // 将right每次左移4位，直到left和right在同一节
        while (left+4<=right){
            right-=4;
        }

        // 循环处理数字的一节，每次处理4位或者最后一次小于4位
        while (left<length){
            // flag为false的时候，表示没有积累的0
            boolean flag = false;

            // isPrint为false的时候，表示该节没有输出过其中的位
            boolean isPrint = false;

            // 从左到右处理这一节的每一位
            while (left<=right){
                if (left>0 && s.charAt(left)=='0'){
                    flag = true;
                }else {
                    if (flag==true){
                        System.out.print(" ling");
                        flag = false;
                    }
                    // 只要不是首位（包括负号），后面的每一位前面都要输出空格
                    if (left>0) System.out.print(" ");

                    // 输出当前的数字
                    System.out.print(num[s.charAt(left)-'0']);
                    isPrint = true;

                    // 每节中除了个位以外，都要输出十百千
                    if (left!=right) {
                        System.out.print(" "+wei[right-left-1]);
                    }
                }
                left++;
            }
            // 只要不是个位，就要输出万或者亿
            if (isPrint==true && right!=length-1){
                System.out.print(" "+wei[(length-1-right)/4+2]);
            }
            right+=4;
        }
    }
}
