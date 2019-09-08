package package7_2;

/**
 * @ClassName A1056
 * @Description 1056. Mice and Rice
 * @Author shishi
 * @Date 2019/8/31 16:53
 **/

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 11 3
 * 25 18 0 46 37 3 19 22 57 56 10
 * 6 0 8 7 10 5 9 1 4 2 3
 */
public class A1056 {
    public static void main(String[] args) {
       Mouse[] mice = new Mouse[1010];
        Scanner scanner = new Scanner(System.in);
        // 老鼠的数量
        int NP = scanner.nextInt();
        // 一组几只老鼠
        int NG = scanner.nextInt();
        // 输入老鼠的质量
        for (int i=0;i<NP;i++){
            int weight = scanner.nextInt();
            // 一定要new一个对象出来，不然会空指针异常
            Mouse mouse = new Mouse();
            mouse.weight = weight;
            mice[i] = mouse;
        }

        // 定义一个队列
        Queue<Integer> queue = new LinkedList<>();
        // 输入初始的顺序，并将初始顺序推入队列
        for (int i=0;i<NP;i++){
            int order = scanner.nextInt();
            queue.offer(order);
        }

        // 初始比赛老鼠的个数
        int temp = NP;
        // 比赛分成的组数
        int group;

        // 当队列里只剩第一名时候就停止
        while (queue.size()!=1){
            // 计算组数的值
            if (temp%NG==0){
                group = temp/NG;
            }else {
                group = temp/NG+1;
            }

            // 枚举每一组的老鼠，选出一个最大质量的老鼠
            for (int i=0;i<group;i++){
                // k为这一组质量最大的老鼠的编号(先进先出)
                int k = queue.peek();
                for (int j=0;j<NG;j++){
                    // 最后一组老鼠数量不足NG时，退出循环
                    if (i*NG + j >=temp) break;

                    //　队首老鼠的编号
                    int peek = queue.peek();
                    // 找出这一组中质量最大的老鼠
                    if (mice[peek].weight > mice[k].weight) {
                        k = peek;
                    }
                    // 这轮的老鼠排名都更新为group+1,并出列
                    mice[peek].range = group+1;
                    queue.poll();
                }
                // 把这一组胜利的老鼠的编号入队
                queue.offer(k);
            }
            // 一轮结束，剩下group只老鼠，更新temp
            temp = group;
        }
        // 只剩最后一只老鼠的时候，这只老鼠的排名为1
        mice[queue.poll()].range = 1;

        // 输出所有老鼠的信息
       for (int i=0;i<NP;i++){
            System.out.print(mice[i].range);
            if (i!=NP-1) System.out.print(" ");
        }
    }
}

class Mouse {
    int weight;
    int range;

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }
}
