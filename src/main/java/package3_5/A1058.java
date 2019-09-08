package package3_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @ClassName A1058
 * @Description 1058. A+B in Hogwarts
 * @Author shishi
 * @Date 2019/8/16 13:59
 **/
public class A1058 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = bf.readLine();
        bf.close();
        String[] strings = s.split(" ");
        // 用.分割的话，需要先转义，因为split函数内部是用正则表达式实现的，.符号在正则表达式是有意义的，所以需要先转义
        String[] A = strings[0].split("\\.");
        String[] B = strings[1].split("\\.");
        // 将字符串转成int型
        int knuts = Integer.valueOf(A[2]) + Integer.valueOf(B[2]);
        int carry_K = knuts / 29;
        knuts = knuts % 29;

        int sickle = Integer.valueOf(A[1])+ Integer.valueOf(B[1]) + carry_K;
        int carry_G = sickle / 17;
        sickle = sickle % 17;

        int galleon = Integer.valueOf(A[0]) + Integer.valueOf(B[0]) + carry_G;

        System.out.println(galleon+"."+sickle+"."+knuts);
    }
}
