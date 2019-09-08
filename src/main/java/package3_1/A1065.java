package package3_1;

import java.util.Scanner;

/**
 * @ClassName A1065
 * @Description 1065. A+B and C (64bit)
 * @Author shishi
 * @Date 2019/9/4 17:33
 **/
public class A1065 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int queryNum = scanner.nextInt();
        for (int i=1;i<=queryNum;i++){
            boolean flag;
            long A = scanner.nextLong();
            long B = scanner.nextLong();
            long C = scanner.nextLong();
            long sum = A+B;
            // 正溢出了，说明A+B是比C大了
            if (A>0 && B>0 && sum<0) flag = true;
            // 负溢出
            else if (A<0 && B<0 && sum>=0) flag = false;
            else if (sum>C) flag = true;
            else flag = false;

            if (flag==true) {
                System.out.println("Case #" + i + ": " + "true");
            }
            else System.out.println("Case #" + i + ": " + "false");
        }
    }
}
