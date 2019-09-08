package package4_1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @ClassName A1062_2
 * @Description 1062. 用算法笔记上的方法写的，还是一模一样，三个case超时
 * @Author shishi
 * @Date 2019/8/25 15:09
 **/
public class A1062_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int totalNum = scanner.nextInt();
        int lowScore = scanner.nextInt();
        int highScore = scanner.nextInt();
        // 建一个student的数组
        Student_1062[] students = new Student_1062[totalNum];
        int validNum = 0;
        for (int i=0;i<totalNum;i++){
            int stu_id = scanner.nextInt();
            int virture_grade = scanner.nextInt();
            int talent_grade = scanner.nextInt();
            // 有效的
            if (virture_grade>=lowScore && talent_grade>=lowScore) {
                Student_1062 student = new Student_1062();
                student.stu_id = stu_id;
                student.virture_grade = virture_grade;
                student.talent_grade = talent_grade;
                student.sum_grade = virture_grade+talent_grade;
                // sage
                if (virture_grade>=highScore && talent_grade>=highScore) {
                    student.flag = 1;
                    students[validNum++] = student;
                }
                // nobleman
                else if (virture_grade>=highScore) {
                    student.flag = 2;
                    students[validNum++] = student;
                }
                // foolman
                else if (virture_grade>=talent_grade) {
                    student.flag = 3;
                    students[validNum++] = student;
                }
                // smallman
                else {
                    student.flag = 4;
                    students[validNum++] = student;
                }
            }
        }

        Arrays.sort(students, 0, validNum, new Comparator<Student_1062>() {
            @Override
            public int compare(Student_1062 stu1, Student_1062 stu2) {
                if (stu1.flag!=stu2.flag) return stu1.flag-stu2.flag;
                else if (stu1.sum_grade!=stu2.sum_grade) return stu2.sum_grade-stu1.sum_grade;
                else if (stu1.virture_grade!=stu2.virture_grade) return stu2.virture_grade-stu1.virture_grade;
                else return stu1.stu_id-stu2.stu_id;
            }
        });

        // 输出
        System.out.println(validNum);
        for (int i=0;i<validNum;i++){
            System.out.println(students[i].stu_id + " " + students[i].virture_grade + " " + students[i].talent_grade);
        }
    }
}

class Student_1062{
    int stu_id;
    int virture_grade;
    int talent_grade;
    int sum_grade;
    int flag; // 标志是哪一类的学生，sage/nobleman/foolman/smallman
}
