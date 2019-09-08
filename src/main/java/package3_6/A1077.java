package package3_6;

import java.util.Scanner;

/**
 * @ClassName A1077
 * @Description 1077. Kuchiguse
 * @Author shishi
 * @Date 2019/9/5 19:11
 **/
public class A1077 {
    // 寻找公共后缀
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        scanner.nextLine();

        String[] strings = new String[n];
        for (int i=0;i<n;i++) {
            strings[i] = scanner.nextLine();
        }

        // 遍历string数组，从后往前遍历
        // 先取第一个字符串，从后往前比较
        String first_str = strings[0];
        int count=0;
        int i;
        boolean flag = true;
        for (i=first_str.length()-1;i>=0;i--) {
            char cur_char = first_str.charAt(i);
            // 比较剩下的字符串
            for (int j=1;j<strings.length;j++) {
                if (flag==false) break;
                String left_str = strings[j];
                int index = left_str.length()-1-count;
                if (left_str.charAt(index)!=cur_char){
                    flag=false;
                }
            }
            if (flag==false) break;
            count++;
        }

        if (count==0){
            System.out.println("nai");
        }else {
            String result = first_str.substring(i+1);
            System.out.println(result);
        }

    }

}
