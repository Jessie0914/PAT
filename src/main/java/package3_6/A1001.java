package package3_6;

import java.util.Scanner;

/**
 * @ClassName A1001
 * @Description 1001. A+B Format
 * @Author shishi
 * @Date 2019/8/6 12:10
 **/
public class A1001 {
    public static void main(String[] args) {
        // 开挂的做法
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        // 格式化输出printf，需要好好学习一下
        System.out.printf("%，d",a+b);

//        formatNum();
    }

    // 标准的做法，归类为“字符串处理”
    public static void formatNum(){
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int sum = a+b;
        // 对0不做特殊处理，有一个测试用例通不过
        if (sum==0) System.out.println(0);

        boolean isNegative = false;
        if (sum<0) {
            isNegative = true;
            sum = -sum;
        }

        // 将sum存入数组
        int[] nums = new int[20];
        int index = 0;
        while (sum>0){
            nums[index++] = sum%10;
            sum/=10;
        }

        if (isNegative==true)
            System.out.print("-");

        // 然后格式化输出
        for (int i=index-1;i>=0;i--){
            System.out.print(nums[i]);
            // 每3个输出一个逗号，但是最后一位不要输出逗号
            if (i>0&&i%3==0) System.out.print(",");
        }
    }
}
