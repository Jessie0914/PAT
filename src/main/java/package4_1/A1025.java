package package4_1; /**
 * @ClassName A1025
 * @Description 1025. PAT Ranking
 * @Author shishi
 * @Date 2019/8/15 20:57
 **/

import java.util.*;

/**
 * 2
 * 5
 * 1234567890001 95
 * 1234567890005 100
 * 1234567890003 95
 * 1234567890002 77
 * 1234567890004 85
 * 4
 * 1234567890013 65
 * 1234567890011 25
 * 1234567890014 100
 * 1234567890012 85
 */
public class A1025 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> allScoreMap = new HashMap<>();
        Map<String, Integer> testNumOfStu = new HashMap<>();
        Map<String, Integer> localGradeMap = new HashMap<>();
        Map<String, Integer> globalGradeMap = new HashMap<>();
        int numberOfTestLocations = scanner.nextInt();
        for (int i=0;i<numberOfTestLocations;i++){
            Map<String, Integer> localScoreMap = new HashMap<>();
            int numOfLocal = scanner.nextInt();
            for (int j=0;j<numOfLocal;j++){
                String stuId = scanner.next();
                int score = scanner.nextInt();
                allScoreMap.put(stuId,score);
                localScoreMap.put(stuId,score);
                // 记录学生对应的考场号
                testNumOfStu.put(stuId,i+1);
            }
            // 一个考场学生信息录入完毕，那么先排序一个考场的grade
            List<Map.Entry<String, Integer>> localList = new ArrayList<>(localScoreMap.entrySet());
            Collections.sort(localList, new Comparator<Map.Entry<String, Integer>>() {
                @Override
                public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                    if (o1.getValue()==o2.getValue()) return o1.getKey().compareTo(o2.getKey());
                    else return o2.getValue().compareTo(o1.getValue());
                }
            });
            // 然后记录当前考场的名次
            int index = 1;
            for (int k=0;k<localList.size();k++){
                Map.Entry<String, Integer> entry = localList.get(k);
                String stuId = entry.getKey();
                if (k>0){
                    // 如果和上一个人的分数一样，那么就和上一个人的排名一样
                    if (entry.getValue()==localList.get(k-1).getValue()){
                        localGradeMap.put(stuId,localGradeMap.get(localList.get(k-1).getKey()));
                        index++;
                    }else {
                        localGradeMap.put(stuId,index);
                        index++;
                    }
                }else {
                    localGradeMap.put(stuId,1);
                    index++;
                }
            }
        }

        List<Map.Entry<String, Integer>> allScoreList = new ArrayList<>(allScoreMap.entrySet());
        Collections.sort(allScoreList, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if (o1.getValue()==o2.getValue()) return o1.getKey().compareTo(o2.getKey());
                else return o2.getValue().compareTo(o1.getValue());
            }
        });

        int globalIndex = 1;
        for (int i=0;i<allScoreList.size();i++){
            Map.Entry<String, Integer> entry = allScoreList.get(i);
            String stuId = entry.getKey();
            if (i>0){
                if (entry.getValue()==allScoreList.get(i-1).getValue()){
                    globalGradeMap.put(stuId,globalGradeMap.get(allScoreList.get(i-1).getKey()));
                    globalIndex++;
                }else {
                    globalGradeMap.put(stuId,globalIndex);
                    globalIndex++;
                }
            }else {
                globalGradeMap.put(stuId,1);
                globalIndex++;
            }
        }

        System.out.println(allScoreMap.size());
        for (int i=0;i<allScoreList.size();i++){
            Map.Entry<String, Integer> entry = allScoreList.get(i);
            String stuId = entry.getKey();
            int globalGrade = globalGradeMap.get(stuId);
            int testNum = testNumOfStu.get(stuId);
            int localGrade = localGradeMap.get(stuId);
            System.out.println(stuId+" "+globalGrade+" "+testNum+" "+localGrade);
        }
    }
}
