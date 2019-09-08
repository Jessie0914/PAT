package package3_1;

import java.util.*;

/**
 * @ClassName A1002
 * @Description 1002. A+B for Polynomials
 * @Author shishi
 * @Date 2019/8/7 20:32
 **/
public class A1002 {
    public static void main(String[] args) {
        Map<Integer, Double> hashMap = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        // 输入第一个多项式，将对应的指数和系数放入map
        int first = scanner.nextInt();
        while (first>0){
            int exponents = scanner.nextInt();
            double coefficients = scanner.nextDouble();
            hashMap.put(exponents,coefficients);
            first--;
        }

        // 输入第二个多项式，将对应的指数和系数放入map
        // 如果发现map已经有key为此指数的项，就将原来的值+自己的值再放入map
        int second = scanner.nextInt();
        while (second>0){
            int exponents = scanner.nextInt();
            double coefficients = scanner.nextDouble();
            Double aDouble = hashMap.getOrDefault(exponents, 0.0);
            // 如果正负抵消的话，直接删除这条记录(坑点！！！)
            if (aDouble+coefficients==0.0){
                hashMap.remove(exponents);
            }else {
                hashMap.put(exponents,aDouble+coefficients);
            }
            second--;
        }

        // 先输出最终多项式的size
        int size = hashMap.size();
        if (size==0) System.out.println(0);
        else System.out.print(size+" ");

        // 将key排序（重要）
        Set<Integer> set = hashMap.keySet();
        Object[] arr = set.toArray();
        Arrays.sort(arr);

        // 用于格式控制（不要输出多余的空格）
        int index = 1;
        // 根据key从大到小开始对应输出
        for (int i = arr.length-1;i>=0;i--){
            Object key = arr[i];
            // 控制只输出一位小数的第一种方法
//            double value = hashMap.get(key);
//            String strValue = String.format("%.1f", value);
//            value = Double.parseDouble(strValue);

            if (index!=size ){
                // 控制只输出一位小数的第二种方法
                System.out.printf("%d %.1f ",key,hashMap.get(key));
                index++;
            }else {
                System.out.printf("%d %.1f",key,hashMap.get(key));
                index++;
            }
        }
    }
}
