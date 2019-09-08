package package4_6;

/**
 * @ClassName A1029
 * @Description 1029. Median
 * @Author shishi
 * @Date 2019/9/7 16:46
 **/
import java.util.Scanner;
// 牛客网通过了所有的case，pat除了超时，还有一个case没过
public class A1029 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int firstNum = scanner.nextInt();
        long[] firstArray = new long[firstNum];
        for (int i = 0; i < firstNum; i++) {
            firstArray[i] = scanner.nextLong();
        }

        int secondNum = scanner.nextInt();
        long[] secondArray = new long[secondNum];
        for (int i = 0; i < secondNum; i++) {
            secondArray[i] = scanner.nextLong();
        }

        int middle = (firstNum + secondNum-1) /2;
        int i=0, j=0;
        int index = 0;
        while (i<firstNum && j<secondNum) {
            if (firstArray[i]<secondArray[j]) {
                index++;
                if (index==middle+1) {
                    System.out.println(firstArray[i]);
                    return;
                }
                i++;
            }else {
                index++;
                if (index==middle+1) {
                    System.out.println(secondArray[j]);
                    return;
                }
                j++;
            }
        }
    }
}
