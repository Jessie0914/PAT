package package3_2;
/**
 * @ClassName A1006
 * @Description 1006.
 * @Author shishi
 * @Date 2019/8/8 11:07
 **/

import java.util.Scanner;

/**
 * 输入：
 * 3
 * CS301111 15:30:28 17:00:10
 * SC3021234 08:00:00 11:25:25
 * CS301133 21:45:00 21:58:40
 *
 * 输出：
 * SC3021234 CS301133
 */
public class A1006 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numOfRecords = scanner.nextInt();
        // 用一个二维数组来存储，一维的宽度为3
        String[][] records = new String[numOfRecords][3];
        for (int i=0;i<numOfRecords;i++){
            for (int j=0;j<3;j++){
                records[i][j] = scanner.next();
            }
        }

        // 先暂时将第一个人作为目标
        String firstSignInId = records[0][0];
        String lastSignOutId = records[0][0];
        String firstSignInTime = records[0][1];
        String lastSignOutTime = records[0][2];

        // 遍历数组，比较所有人的sign in 和sign out时间，不断更改firstSignInId和lastSignOutId
        for (int i=1;i<numOfRecords;i++){
            String currentId = records[i][0];
            String currentSignInTime = records[i][1];
            String currentSignOutTime = records[i][2];

            // 比较sign in时间
            String[] fisrtSignInArray = firstSignInTime.split(":");
            String[] currentSignInArray = currentSignInTime.split(":");
            for (int k=0;k<3;k++){
                // 如果比firstSignInId更早，那么就更新firstSignInId
                if (currentSignInArray[k].compareTo(fisrtSignInArray[k])<0){
                    firstSignInId = currentId;
                    firstSignInTime = currentSignInTime;
                    break;
                }
            }

            // 比较sign out时间
            String[] lastSignOutArray = lastSignOutTime.split(":");
            String[] currentSignOutArray = currentSignOutTime.split(":");
            for (int k=0;k<3;k++) {
                // 如果比lastSignOutId更晚，那就更新lastSignOutId
                if (currentSignOutArray[k].compareTo(lastSignOutArray[k]) > 0) {
                    lastSignOutId = currentId;
                    lastSignOutTime = currentSignOutTime;
                    break;
                }
            }
        }

        System.out.println(firstSignInId+" "+lastSignOutId);
    }
}
