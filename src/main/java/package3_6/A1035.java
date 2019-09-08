package package3_6;

/**
 * @ClassName A1035
 * @Description 1035. Password
 * @Author shishi
 * @Date 2019/9/5 15:33
 **/

import java.util.*;

/**
 * 0->%
 * O->o
 * 1->@
 * l->L
 */
public class A1035 {
    // 一开始我用的hashmap，后来发现它的输出顺序和输入顺序不一致，不可控，换成了LinkedHashMap就可
    // 或者新建一个类，存放它的name password以及一个boolean的变量，然后构造一个类的数组来做
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Map<String, String> originalMap = new LinkedHashMap<>();
        Map<String, String> modifiedMap = new LinkedHashMap<>();

        for (int i=0;i<n;i++) {
            String name = scanner.next();
            String password = scanner.next();
            originalMap.put(name,password);
        }

        // 遍历原始map
        int modifiedNum = originalMap.size();
        Iterator<String> iterator = originalMap.keySet().iterator();
        while (iterator.hasNext()) {
            String name = iterator.next();
            String password = originalMap.get(name);
            boolean modified = false;

            char[] chars = password.toCharArray();
            for (int i=0;i<chars.length;i++) {
                if (chars[i] == '1') {
                    chars[i] = '@';
                    modified = true;
                }
                else if (chars[i]=='0') {
                    chars[i] = '%';
                    modified = true;
                }
                else if (chars[i]=='l') {
                    chars[i] = 'L';
                    modified = true;
                }
                else if (chars[i]=='O') {
                    chars[i] = 'o';
                    modified = true;
                }
            }

            // 如果没有修改过
            if (modified==false) {
                modifiedNum--;
            }else {
                String modifiedPassword = String.valueOf(chars);
                modifiedMap.put(name,modifiedPassword);
            }
        }

        // 如果一条没有修改
        if (modifiedNum==0) {
            if (originalMap.size()==1) {
                System.out.println("There is 1 account and no account is modified");
            }else {
                System.out.println("There are " + originalMap.size() + " accounts and no account is modified");
            }
        }else {
            System.out.println(modifiedNum);
            Iterator<String> iterator1 = modifiedMap.keySet().iterator();
            while (iterator1.hasNext()) {
                String name = iterator1.next();
                String password = modifiedMap.get(name);
                System.out.println(name + " " + password);
            }
        }
    }
}
