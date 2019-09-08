package package4_1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @ClassName A1028_2
 * @Description TODO
 * @Author shishi
 * @Date 2019/8/15 13:19
 **/
public class A1028_2 {
    // 还是超时了……
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfStu = scanner.nextInt();
        int queryID = scanner.nextInt();
        // 只是声明了数组而已，并没有真正创建了空间
        Student[] students = new Student[100001];
        for (int i=0;i<numberOfStu;i++){
            // 这一行代码非常重要，不写的话，就会报空指针异常
            // 所以给内部类对象数组属性赋值时，必须要先new一个对象出来
            students[i] = new Student();
            students[i].stuID = scanner.next();
            students[i].name = scanner.next();
            students[i].grade = scanner.nextInt();
        }
        if (queryID==1){
            Arrays.sort(students, 0, numberOfStu, new Comparator<Student>() {
                @Override
                public int compare(Student o1, Student o2) {
                    return o1.stuID.compareTo(o2.stuID);
                }
            });
        }
        else if (queryID==2){
            Arrays.sort(students, 0, numberOfStu, new Comparator<Student>() {
                @Override
                public int compare(Student o1, Student o2) {
                    if (o1.name.equals(o2.name)) return o1.stuID.compareTo(o2.stuID);
                    else return o1.name.compareTo(o2.name);
                }
            });
        }
        else {
            Arrays.sort(students, 0, numberOfStu, new Comparator<Student>() {
                @Override
                public int compare(Student o1, Student o2) {
                    if (o1.grade==o2.grade) return o1.stuID.compareTo(o2.stuID);
                    else return o1.grade-o2.grade;
                }
            });
        }

        for (int i=0;i<numberOfStu;i++){
            System.out.println(students[i].stuID+" "+students[i].name+" "+students[i].grade);
        }
    }
}

class Student {
    String stuID;
    String name;
    int grade;

    public String getStuID() {
        return stuID;
    }

    public void setStuID(String stuID) {
        this.stuID = stuID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }
}
