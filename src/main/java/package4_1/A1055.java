package package4_1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @ClassName A1055
 * @Description 1055. The World's Richest
 * @Author shishi
 * @Date 2019/9/6 17:17
 **/
public class A1055 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int queryNum = scanner.nextInt();

        People[] peoples = new People[n];
        // 输入所有富商的信息
        for (int i = 0; i < n; i++) {
            People p = new People();
            p.name = scanner.next();
            p.age = scanner.nextInt();
            p.wealth = scanner.nextInt();
            peoples[i] = p;
        }

        // 排序，先按照财富值从大到小排序，然后按照年龄从小到大排序，最后按照name排序
        Arrays.sort(peoples, 0, n, new Comparator<People>() {

            @Override
            public int compare(People o1, People o2) {
                if (o1.wealth!=o2.wealth) {
                    return o2.wealth-o1.wealth;
                }
                else if (o1.age!=o2.age) {
                    return o1.age - o2.age;
                }
                else {
                    return o1.name.compareTo(o2.name);
                }
            }

        });

        // 然后输入查询
        for (int i = 1; i <= queryNum; i++) {
            int num = scanner.nextInt();
            int minAge = scanner.nextInt();
            int maxAge = scanner.nextInt();
            System.out.println("Case #"+i+":");
            int index = 0;
            for (int j = 0; j < peoples.length; j++) {
                People people = peoples[j];
                // 如果年龄符合要求
                if (index<num && people.age>=minAge && people.age<=maxAge) {
                    System.out.println(people.name + " " + people.age + " " + people.wealth);
                    index++;
                }
            }
            if (index==0) {
                System.out.println("None");
            }
        }
    }
}

class People {
    String name;
    int age;
    int wealth;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public int getWealth() {
        return wealth;
    }
    public void setWealth(int wealth) {
        this.wealth = wealth;
    }

}
