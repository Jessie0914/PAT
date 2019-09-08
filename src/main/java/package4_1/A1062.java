package package4_1;

import java.util.*;

/**
 * @ClassName A1062
 * @Description 1062. Talent and Virtue
 * @Author shishi
 * @Date 2019/8/24 15:53
 **/
public class A1062 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<Integer, int[]> sageMap = new HashMap<>();
        Map<Integer, int[]> noblemanMap = new HashMap<>();
        Map<Integer, int[]> foolmanMap = new HashMap<>();
        Map<Integer, int[]> smallmanMap = new HashMap<>();
        int totalNum = scanner.nextInt();
        int lowScore = scanner.nextInt();
        int highScore = scanner.nextInt();
        int validNum = 0;
        for (int i=0;i<totalNum;i++){
            int stu_id = scanner.nextInt();
            int virture_grade = scanner.nextInt();
            int talent_grade = scanner.nextInt();
            if (virture_grade>=lowScore && talent_grade>=lowScore){
                validNum++;
                // 圣人
                if (virture_grade>=highScore && talent_grade>=highScore){
                    int[] array = {virture_grade, talent_grade};
                    sageMap.put(stu_id,array);
                }
                // 君子
                else if (virture_grade>=highScore){
                    int[] array = {virture_grade, talent_grade};
                    noblemanMap.put(stu_id,array);
                }
                // 愚人
                else if (virture_grade>=talent_grade){
                    int[] array = {virture_grade, talent_grade};
                    foolmanMap.put(stu_id,array);
                }
                // 小人
                else {
                    int[] array = {virture_grade, talent_grade};
                    smallmanMap.put(stu_id,array);
                }
            }
        }

        // 排序规则
        // 先按照总分排名；然后按照vir>tal排；最后按照id排序
        List<Map.Entry<Integer, int[]>> sageList = new ArrayList<>(sageMap.entrySet());
        Collections.sort(sageList, new Comparator<Map.Entry<Integer, int[]>>() {
            @Override
            public int compare(Map.Entry<Integer, int[]> o1, Map.Entry<Integer, int[]> o2) {
                int id1 = o1.getKey();
                int id2 = o2.getKey();
                int[] array1 = o1.getValue();
                int[] array2 = o2.getValue();
                int score1 = array1[0] + array1[1];
                int score2 = array2[0] + array2[1];
                if (score1!=score2) return score2-score1;
                else if (array1[0]!=array2[0]) return array2[0]-array1[0];
                else return id1-id2;
            }
        });

        List<Map.Entry<Integer, int[]>> noblemanList = new ArrayList<>(noblemanMap.entrySet());
        Collections.sort(noblemanList, new Comparator<Map.Entry<Integer, int[]>>() {
            @Override
            public int compare(Map.Entry<Integer, int[]> o1, Map.Entry<Integer, int[]> o2) {
                int id1 = o1.getKey();
                int id2 = o2.getKey();
                int[] array1 = o1.getValue();
                int[] array2 = o2.getValue();
                int score1 = array1[0] + array1[1];
                int score2 = array2[0] + array2[1];
                if (score1!=score2) return score2-score1;
                else if (array1[0]!=array2[0]) return array2[0]-array1[0];
                else return id1-id2;
            }
        });

        List<Map.Entry<Integer, int[]>> foolmanList = new ArrayList<>(foolmanMap.entrySet());
        Collections.sort(foolmanList, new Comparator<Map.Entry<Integer, int[]>>() {
            @Override
            public int compare(Map.Entry<Integer, int[]> o1, Map.Entry<Integer, int[]> o2) {
                int id1 = o1.getKey();
                int id2 = o2.getKey();
                int[] array1 = o1.getValue();
                int[] array2 = o2.getValue();
                int score1 = array1[0] + array1[1];
                int score2 = array2[0] + array2[1];
                if (score1!=score2) return score2-score1;
                else if (array1[0]!=array2[0]) return array2[0]-array1[0];
                else return id1-id2;
            }
        });

        List<Map.Entry<Integer, int[]>> smallmanList = new ArrayList<>(smallmanMap.entrySet());
        Collections.sort(smallmanList, new Comparator<Map.Entry<Integer, int[]>>() {
            @Override
            public int compare(Map.Entry<Integer, int[]> o1, Map.Entry<Integer, int[]> o2) {
                int id1 = o1.getKey();
                int id2 = o2.getKey();
                int[] array1 = o1.getValue();
                int[] array2 = o2.getValue();
                int score1 = array1[0] + array1[1];
                int score2 = array2[0] + array2[1];
                if (score1!=score2) return score2-score1;
                else if (array1[0]!=array2[0]) return array2[0]-array1[0];
                else return id1-id2;
            }
        });

        //输出
        System.out.println(validNum);
        for (int i=0;i<sageList.size();i++){
            Map.Entry<Integer, int[]> entry = sageList.get(i);
            int stu_id = entry.getKey();
            int[] array = entry.getValue();
            System.out.println(stu_id + " "+array[0] + " " + array[1]);
        }

        for (int i=0;i<noblemanList.size();i++){
            Map.Entry<Integer, int[]> entry = noblemanList.get(i);
            int stu_id = entry.getKey();
            int[] array = entry.getValue();
            System.out.println(stu_id + " "+array[0] + " " + array[1]);
        }

        for (int i=0;i<foolmanList.size();i++){
            Map.Entry<Integer, int[]> entry = foolmanList.get(i);
            int stu_id = entry.getKey();
            int[] array = entry.getValue();
            System.out.println(stu_id + " "+array[0] + " " + array[1]);
        }

        for (int i=0;i<smallmanList.size();i++){
            Map.Entry<Integer, int[]> entry = smallmanList.get(i);
            int stu_id = entry.getKey();
            int[] array = entry.getValue();
            System.out.println(stu_id + " "+array[0] + " " + array[1]);
        }
    }
}