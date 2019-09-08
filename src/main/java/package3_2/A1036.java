package package3_2;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

/**
 * @ClassName A1036
 * @Description 1036. Boys vs Girls
 * @Author shishi
 * @Date 2019/9/4 19:39
 **/
public class A1036 {
    // 这题的坑点在于…………它不保证id唯一，只保证grade唯一，所以一开始建立的hashmap是ID->Grade，后来改成Grade->id ,grade->name就都对了
    public static void main(String[] args) {
        // grade -> ID
        Map<Integer, String> maleGradeMap = new HashMap<>();
        Map<Integer, String> femaleGradeMap = new HashMap<>();

        // grade -> name
        Map<Integer, String> nameMap = new HashMap<>();

        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        for (int i=0;i<number;i++) {
            String name = scanner.next();
            String gender = scanner.next();
            String id = scanner.next();
            int grade = scanner.nextInt();

            if (gender.equals("M")) maleGradeMap.put(grade,id);
            else femaleGradeMap.put(grade,id);
            nameMap.put(grade,name);
        }

        boolean NA = false;

        String highestFemaleId = "";
        int highestFemaleGrade = Integer.MIN_VALUE;
        if (femaleGradeMap.size()==0) {
            NA = true;
            System.out.println("Absent");
        }else {
            // 找到女性里面分数最高的一个
            Iterator<Integer> iterator = femaleGradeMap.keySet().iterator();
            while (iterator.hasNext()) {
                int grade = iterator.next();
                String id = femaleGradeMap.get(grade);
                if (grade>highestFemaleGrade){
                    highestFemaleGrade = grade;
                    highestFemaleId = id;
                }
            }
            System.out.println(nameMap.get(highestFemaleGrade)+" "+highestFemaleId);
        }

        String lowestMaleId = "";
        int lowestMaleGrade = Integer.MAX_VALUE;
        if (maleGradeMap.size()==0) {
            NA = true;
            System.out.println("Absent");
        }else {
            // 找到男性里面分数最低的一个
            Iterator<Integer> iterator = maleGradeMap.keySet().iterator();
            while (iterator.hasNext()) {
                int grade = iterator.next();
                String id = maleGradeMap.get(grade);
                if (grade<lowestMaleGrade) {
                    lowestMaleGrade = grade;
                    lowestMaleId = id;
                }
            }
            System.out.println(nameMap.get(lowestMaleGrade)+ " " + lowestMaleId);
        }

        if (NA==true) {
            System.out.println("NA");
        }else {
            System.out.println(highestFemaleGrade-lowestMaleGrade);
        }
    }
}
