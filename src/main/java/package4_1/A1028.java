package package4_1; /**
 * @ClassName A1028
 * @Description 1028. List Sorting
 * @Author shishi
 * @Date 2019/8/15 12:10
 **/
import java.util.*;

/**
 * 3 1
 * 000007 James 85
 * 000010 Amy 90
 * 000001 Zoe 60
 *
 * 000001 Zoe 60
 * 000007 James 85
 * 000010 Amy 90
 */
public class A1028 {
    // 用java超时了，然后写了p1028_2，还是超时了。。。
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfStu = scanner.nextInt();
        int queryID = scanner.nextInt();
        Map<String, String> nameMap = new HashMap<>();
        Map<String, Integer> gradeMap = new HashMap<>();
        for (int i=0;i<numberOfStu;i++){
            String stuID = scanner.next();
            String name = scanner.next();
            int grade = scanner.nextInt();
            nameMap.put(stuID,name);
            gradeMap.put(stuID,grade);
        }
        if (queryID==1) queryWithID(nameMap,gradeMap);
        else if (queryID==2) queryWithName(nameMap,gradeMap);
        else queryWithGrade(nameMap,gradeMap);
    }

    private static void queryWithGrade(Map<String, String> nameMap, Map<String, Integer> gradeMap) {
        List<Map.Entry<String, Integer>> gradeList = new ArrayList<>(gradeMap.entrySet());
        Collections.sort(gradeList, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });
        for (int i=0;i<gradeList.size();i++){
            Map.Entry<String, Integer> entry = gradeList.get(i);
            String stuID = entry.getKey();
            String name = nameMap.get(stuID);
            int grade = entry.getValue();
            System.out.println(stuID+" "+name+" "+grade);
        }
    }

    private static void queryWithName(Map<String, String> nameMap, Map<String, Integer> gradeMap) {
        List<Map.Entry<String, String>> nameList = new ArrayList<>(nameMap.entrySet());
        Collections.sort(nameList, new Comparator<Map.Entry<String, String>>() {
            @Override
            public int compare(Map.Entry<String, String> o1, Map.Entry<String, String> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });
        for (int i=0;i<nameList.size();i++){
            Map.Entry<String, String> entry = nameList.get(i);
            String stuID = entry.getKey();
            String name = entry.getValue();
            int grade = gradeMap.get(stuID);
            System.out.println(stuID+" "+name+" "+grade);
        }
    }

    private static void queryWithID(Map<String, String> nameMap, Map<String, Integer> gradeMap) {
//        排序的第一种方法
//        Set<String> set = nameMap.keySet();
//        Object[] array = set.toArray();
//        Arrays.sort(array);
//        for (int i=0;i<array.length;i++){
//            String stuID = (String) array[i];
//            System.out.println(stuID+" "+nameMap.get(stuID)+" "+gradeMap.get(stuID));
//        }

//        排序的第二种方法
        List<Map.Entry<String, String>> list = new ArrayList<>(nameMap.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, String>>() {
            @Override
            public int compare(Map.Entry<String, String> o1, Map.Entry<String, String> o2) {
                return o1.getKey().compareTo(o2.getKey());
            }
        });
        for (int i=0;i<list.size();i++){
            Map.Entry<String, String> entry = list.get(i);
            String stuID = entry.getKey();
            String name = entry.getValue();
            int grade = gradeMap.get(stuID);
            System.out.println(stuID+" "+name+" "+grade);
        }
    }
}
