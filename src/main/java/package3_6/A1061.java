package package3_6;

/**
 * @ClassName A1061
 * @Description 1061. Dating
 * @Author shishi
 * @Date 2019/9/4 21:13
 **/

import java.util.Scanner;

/**
 * 3485djDkxh4hhGE
 * 2984akDfkkkkggEdsb
 * s&hgsfdk
 * d&Hyscvnm
 *
 * THU 14:04
 * THU 和 14 都是前两个字符串推出来的
 * 04是后两个字符串推出来
 */
public class A1061 {
    static int index = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String first_str = scanner.next();
        String seconds_str = scanner.next();
        String third_str = scanner.next();
        String fourth_str = scanner.next();
        String week;
        int hour;
        int minute;

        char[] first_array = first_str.toCharArray();
        char[] second_array = seconds_str.toCharArray();
        char[] third_array = third_str.toCharArray();
        char[] fourth_array = fourth_str.toCharArray();

        // 找周几
        char weekChar = findFirstCapitalLetter(first_array, second_array);
        week = transferToWeek(weekChar);

        // 找hour
        char hourChar = findHour(first_array, second_array);
        hour = transferToHour(hourChar);

        // 找minute
        minute = findMinute(third_array,fourth_array);

        // 输出
        System.out.printf("%s %02d:%02d\n",week,hour,minute);
    }

    // 找minute，为两个字符串相同位置的相同字符
    private static int findMinute(char[] third_array, char[] fourth_array) {
        int i=0;
        while (i<third_array.length) {
            char cur_c = third_array[i];
            if (Character.isLetter(cur_c)) {
                if (cur_c==fourth_array[i])
                    return i;
            }
            i++;
        }
        return -1;
    }

    // 将char字母转换成是第几个小时
    private static int transferToHour(char hourChar) {
        if (Character.isDigit(hourChar))
            return hourChar-'0';
        else if (Character.isUpperCase(hourChar))
            return hourChar-'A'+10;
        else return -1;
    }

    // 找hour，是在找week的基础上继续找第一个相同的字符(0-9,A-N),条件也是位置也要相同……
    private static char findHour(char[] first_array, char[] second_array) {
        int i = index+1;
        while (i<first_array.length && i<second_array.length) {
            char cur_c = first_array[i];
            // 如果是0-9或者A-N(坑点！！！！不是A-Z，而是只到N)
            if (Character.isDigit(cur_c) || (cur_c>='A'&&cur_c<='N')) {
                if (cur_c==second_array[i]){
                    return cur_c;
                }
            }
            i++;
        }
        return ' ';
    }

    // 将char字母转换成是第几天
    // 比如说D字母是第四个字母，就是星期四
    private static String transferToWeek(char weekChar) {
        int weekOrder = (weekChar-'A'+1) % 7;
        if (weekOrder==1) return "MON";
        else if (weekOrder==2) return "TUE";
        else if (weekOrder==3) return "WED";
        else if (weekOrder==4) return "THU";
        else if (weekOrder==5) return "FRI";
        else if (weekOrder==6) return "SAT";
        else return "SUN";
    }

    // 找week，也就是第一第二字符串中第一个相同并且位置相同的大写字母
    private static char findFirstCapitalLetter(char[] first_array, char[] second_array) {
        int i=0;
        while (i<first_array.length && i<second_array.length) {
            char cur_c = first_array[i];
            // 太坑了，不是大写字母，是A-G的大写字母
            // 如果是A-G的大写字母，就开始遍历第二个数组
            if (cur_c>='A' && cur_c<='G') {
                if (cur_c==second_array[i]) {
                    index = i;
                    return cur_c;
                }
            }
            i++;
        }
        return ' ';
    }
}
