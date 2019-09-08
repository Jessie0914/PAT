package package4_1;
/**
 * @ClassName A1012
 * @Description 1012. The Best Rank
 * @Author shishi
 * @Date 2019/8/12 10:10
 **/


import java.util.*;

/**
 * 输入：
 * 5 6
 * 310101 98 85 88
 * 310102 70 95 88
 * 310103 82 87 94
 * 310104 91 91 91
 * 310105 85 90 90
 * 310101
 * 310102
 * 310103
 * 310104
 * 310105
 * 999999
 *
 * 输出：
 * 1 C
 * 1 M
 * 1 E
 * 1 A
 * 3 A
 * N/A
 */
public class A1012 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();

        String[] stuIDs = new String[N];
        int index_C = 0;
        int[] score_C = new int[N];

        int index_M = 0;
        int[] score_M = new int[N];

        int index_E = 0;
        int[] score_E = new int[N];

        int index_A = 0;
        int[] score_A = new int[N];

        // 输入所有的信息
        for (int i=0;i<N;i++){
            String stuId = scanner.next();
            stuIDs[i] = stuId;

            int c = scanner.nextInt();
            score_C[index_C++] = c;
            int m = scanner.nextInt();
            score_M[index_M++] = m;
            int e = scanner.nextInt();
            score_E[index_E++] = e;
            int a = (c+m+e)/3;
            score_A[index_A++] = a;
        }

        // 输入所有待排序的学生
        String[] outputStu = new String[M];
        for (int i=0;i<M;i++){
            outputStu[i] = scanner.next();
            int stuIndex = findIndexOfStu(stuIDs,outputStu[i]);
            if (stuIndex<0) System.out.println("N/A");
            else {
                int grade_C = 1;
                int curScore_C = score_C[stuIndex];
                int grade_M = 1;
                int curScore_M = score_M[stuIndex];
                int grade_E = 1;
                int curScore_E = score_E[stuIndex];
                int grade_A = 1;
                int curScore_A = score_A[stuIndex];

                int grade;
                int score = curScore_C;
                char course = 'C';

                // 对于C科目做比较
                for (int k=0;k<score_C.length;k++){
                    if (score_C[k]>curScore_C){
                        grade_C++;
                    }
                }
                grade = grade_C;
                course = 'C';

                // 对于M科目做比较
                for (int k=0;k<score_M.length;k++){
                    if (score_M[k]>curScore_M){
                        grade_M++;
                        if (grade_M>grade) break;
                    }
                }
                if (grade_M<grade ||(grade_M==grade&&curScore_M>score)){
                    grade = grade_M;
                    course = 'M';
                }

                // 对于E科目做比较
                for (int k=0;k<score_E.length;k++){
                    if (score_E[k]>curScore_E){
                        grade_E++;
                        if (grade_E>grade) break;
                    }
                }
                if (grade_E<grade || (grade_E==grade&&curScore_E>score)){
                    grade = grade_E;
                    course = 'E';
                }


                // 对于A科目做比较
                for (int k=0;k<score_A.length;k++){
                    if (score_A[k]>curScore_A){
                        grade_A++;
                        if (grade_A>grade) break;
                    }
                }
                if (grade_A<grade || (grade_A==grade&&curScore_A>score)){
                    grade = grade_A;
                    course = 'A';
                }

                System.out.println(grade+" "+course);
            }
        }


    }

    private static int findIndexOfStu(String[] stuIDs, String s) {
        for (int i=0;i<stuIDs.length;i++){
            if (stuIDs[i].equals(s)){
                return i;
            }
        }
        return -1;
    }
}
