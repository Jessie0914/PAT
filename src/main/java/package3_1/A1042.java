package package3_1;

/**
 * @ClassName A1042
 * @Description 1042. Shuffling Machine
 * @Author shishi
 * @Date 2019/9/4 15:09
 **/

import java.util.Scanner;

/**
 * 2
 * 36 52 37 38 3 39 40 53 54 41 11 12 13 42 43 44 2 4 23 24 25 26 27 6 7 8 48 49 50 51 9 10 14 15 16 5 17 18 19 1 20 21 22 28 29 30 31 32 33 34 35 45 46 47
 */
public class A1042 {
    public static void main(String[] args) {
        // 54张牌的数组
        String[] cards = new String[54];
        cards[0] = "S1";cards[1] = "S2";cards[2] = "S3";cards[3] = "S4";cards[4] = "S5";cards[5] = "S6";
        cards[6] = "S7";cards[7] = "S8";cards[8] = "S9";cards[9] = "S10";cards[10] = "S11";cards[11] = "S12";cards[12] = "S13";

        cards[13] = "H1";cards[14] = "H2";cards[15] = "H3";cards[16] = "H4";cards[17] = "H5";cards[18] = "H6";
        cards[19] = "H7";cards[20] = "H8";cards[21] = "H9";cards[22] = "H10";cards[23] = "H11";cards[24] = "H12";cards[25] = "H13";

        cards[26] = "C1";cards[27] = "C2";cards[28] = "C3";cards[29] = "C4";cards[30] = "C5";cards[31] = "C6";cards[32] = "C7";
        cards[33] = "C8";cards[34] = "C9";cards[35] = "C10";cards[36] = "C11";cards[37] = "C12";cards[38] = "C13";

        cards[39] = "D1";cards[40] = "D2";cards[41] = "D3";cards[42] = "D4";cards[43] = "D5";cards[44] = "D6";cards[45] = "D7";cards[46] = "D8";
        cards[47] = "D9";cards[48] = "D10";cards[49] = "D11";cards[50] = "D12";cards[51] = "D13";

        cards[52] = "J1";cards[53] = "J2";


        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();

        // 用一个新的数组来存放每次操作后的数据
        String[] newCards = new String[54];
        int[] order = new int[54];
        for (int i=0;i<54;i++){
            order[i] = scanner.nextInt();
        }

        while (k>0) {
            for (int i=0;i<54;i++) {
                newCards[order[i]-1] = cards[i];
            }

            // 把新的newCards的值赋给cards
            for (int i=0;i<54;i++) {
                cards[i] = newCards[i];
            }
            k--;
        }

        // 输出
        for (int i=0;i<cards.length;i++) {
            if (i!=cards.length-1)
                System.out.print(cards[i] + " ");
            else
                System.out.println(cards[i]);
        }

    }
}
