package package3_1;
/**
 * @ClassName A1009
 * @Description 1009. Product of Polynomials
 * @Author shishi
 * @Date 2019/8/11 9:45
 **/

import java.util.*;

/**
 * 多项式的乘积：（product为乘积的意思）
 * 输入：
 * 2 1 2.4 0 3.2
 * 2 2 1.5 1 0.5
 * 输出：
 * 3 3 3.6 2 6.0 1 1.6
 */
public class A1009 {
    // 参考A002
    public static void main(String[] args) {
        Map<Integer, Double> hashMapA = new HashMap<>();
        Map<Integer, Double> hashMap = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        // 输出第一行的数
        int sizaA = scanner.nextInt();
        while (sizaA>0){
            int exponents = scanner.nextInt();
            double coefficents = scanner.nextDouble();
            hashMapA.put(exponents,coefficents);
            sizaA--;
        }

        int sizaB = scanner.nextInt();
        // 输入第二行
        while (sizaB>0){
            int exponents = scanner.nextInt();
            double coefficents = scanner.nextDouble();

            // 每输入一个数据，就要和第一行的所有数据都乘过去
            Iterator<Integer> iterator = hashMapA.keySet().iterator();
            while (iterator.hasNext()){
                Integer A_exponents = iterator.next();
                Double A_coefficents = hashMapA.get(A_exponents);

                int new_exponets = exponents + A_exponents;
                double new_coeffcients = A_coefficents * coefficents;

                Double aDouble = hashMap.getOrDefault(new_exponets,0.0);
                // 如果系数为0.0，那么就直接删除这条记录(坑点！！)
                if (aDouble+new_coeffcients==0.0){
                    hashMap.remove(new_exponets);
                }else hashMap.put(new_exponets,aDouble+new_coeffcients);
            }

            sizaB--;
        }

        // 将key排序
        Set<Integer> set = hashMap.keySet();
        Object[] array = set.toArray();
        Arrays.sort(array);

        // 先输出size
        int size = hashMap.size();
        System.out.print(size);

        // 格式控制
        for (int i=array.length-1;i>=0;i--){
            System.out.print(" ");
            System.out.print(array[i]);
            System.out.print(" ");
            System.out.printf("%.1f",hashMap.get(array[i]));
        }
    }
}
