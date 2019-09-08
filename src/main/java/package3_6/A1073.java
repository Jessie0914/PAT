package package3_6;

/**
 * @ClassName A1073
 * @Description 1073. Scientific Notation
 * @Author shishi
 * @Date 2019/9/5 14:22
 **/

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * +1.23400E-03     ->    0.00123400
 * -1.2E+10         ->    -12000000000
 */
public class A1073 {
    public static void main(String[] args) throws IOException {
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
//        String s = bf.readLine();
//        bf.close();
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        char[] chars = s.toCharArray();

        // 正数还是负数的标志
        boolean isNegative = false;
        if (chars[0]=='-')
            isNegative = true;

        List<Integer> numList = new ArrayList<>();
        int numBdforePoint = 0;
        // 将小数点前面的部分先存入list
        int i=1;
        while (i<chars.length) {
            if (chars[i]!='.'){
                numList.add(chars[i]-'0');
            }else break;
            i++;
        }
        numBdforePoint = i-1;

        // 将E前面的部分继续存入list
        i++;
        while (i<chars.length) {
            if (chars[i]!='E') {
                numList.add(chars[i]-'0');
            }else break;
            i++;
        }

        // 判断E后面跟着的是+ 还是 -
        boolean flag_E = true;
        i++;
        if (chars[i]=='-') flag_E = false;

        // 把E后面的数字存下来
        int exponents = 0;
        i++;
        while (i<chars.length) {
            exponents = exponents * 10 + (chars[i]-'0');
            i++;
        }

        // 先输出正数或者是负数
        System.out.print(!isNegative? "":"-");

        // 如果指数是负的，得往前补0
        if (flag_E==false){
            System.out.print("0.");
            // 要补exponents-1个0
            for (int j=0;j<exponents-1;j++){
                System.out.print("0");
            }

            // 然后将numList中的数字依次输出
            for (int j=0;j<numList.size();j++) {
                System.out.print(numList.get(j));
            }
        }
        // 如果指数是正的，就得在后面补0
        else {
            int numOfZero = exponents-(numList.size()-numBdforePoint);

            // 如果小于0，就需要在合适的位置输出一个.
            if (numOfZero<0) {
                System.out.print(numList.get(0));

                int index = 0;
                for (int j=1;j<numList.size();j++) {
                    if (index==exponents) {
                        System.out.print(".");
                        System.out.print(numList.get(j));
                    }else {
                        System.out.print(numList.get(j));
                    }
                    index++;
                }
            }

            // 如果numOfZero>0，说明不需要输出小数点.
            else {
                // 先输出所有的numList
                for (int j=0;j<numList.size();j++) {
                    System.out.print(numList.get(j));
                }
                // 然后输出剩余的0
                for (int j=0;j<numOfZero;j++){
                    System.out.print("0");
                }
            }
        }
    }
}
