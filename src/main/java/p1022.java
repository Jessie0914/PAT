
import com.sun.xml.internal.bind.v2.model.core.ID;

import java.util.*;
/**
 * @ClassName p1022
 * @Description 1022. Digital Library
 * @Author shishi
 * @Date 2019/8/12 16:02
 **/

// id->title author ……内存会溢出，因为在后面遍历还需要增加对应的list来存放id
public class p1022 {
    static Map<String, Set<String>> titleMap = new HashMap<>();
    static Map<String, Set<String>> authorMap = new HashMap<>();
    static Map<String, Set<String>> keywordsMap = new HashMap<>();
    static Map<String, Set<String>> publisherMap = new HashMap<>();
    static Map<String, Set<String>> yearMap = new HashMap<>();

    static int bookSize;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int bookNum = scanner.nextInt();
        bookSize = bookNum;
        // 吃掉回车符（很重要！！）
        scanner.nextLine();
        // 输入图书信息
        for (int i=0;i<bookNum;i++){
            String stuId = scanner.nextLine();

            String title = scanner.nextLine();
            Set<String> setTitle = titleMap.getOrDefault(title,new HashSet<>());
            setTitle.add(stuId);
            titleMap.put(title,setTitle);

            String author = scanner.nextLine();
            Set<String> setAuthor = authorMap.getOrDefault(author,new HashSet<>());
            setAuthor.add(stuId);
            authorMap.put(author,setAuthor);

            String keywords = scanner.nextLine();
            Set<String> setKeywords = keywordsMap.getOrDefault(keywords,new HashSet<>());
            setKeywords.add(stuId);
            keywordsMap.put(keywords,setKeywords);

            String publisher = scanner.nextLine();
            Set<String> setPublisher = publisherMap.getOrDefault(publisher,new HashSet<>());
            setPublisher.add(stuId);
            publisherMap.put(publisher,setPublisher);

            String year = scanner.nextLine();
            Set<String> setYear = yearMap.getOrDefault(year,new HashSet<>());
            setYear.add(stuId);
            yearMap.put(year,setYear);
        }

        // 输入查询
        int queryNum = scanner.nextInt();
        scanner.nextLine();
        for (int i=0;i<queryNum;i++){
            String queryInfo = scanner.nextLine();
            char queryId = queryInfo.charAt(0);
            String query = queryInfo.substring(3);
            System.out.println(queryInfo);
            if (queryId=='1') queryTitle(query);
            else if (queryId=='2') queryAuthor(query);
            else if (queryId=='3') queryKeywords(query);
            else if (queryId=='4') queryPublisher(query);
            else queryYear(query);
        }
    }

    private static void queryYear(String year) {
        Set<String> set = yearMap.get(year);
        if (set.size()==0) System.out.println("Not Found");
        else {
            Iterator<String> iterator = set.iterator();
            while (iterator.hasNext()){
                System.out.println(iterator.next());
            }
        }
    }

    // 逻辑稍微有点不一样，publisher必须要完全相等才能算是匹配
    private static void queryPublisher(String publisher) {
        Set<String> set = publisherMap.get(publisher);
        if (set.size()==0) System.out.println("Not Found");
        else {
            Iterator<String> iterator = set.iterator();
            while (iterator.hasNext()){
                System.out.println(iterator.next());
            }
        }
    }

    private static void queryKeywords(String keywords) {
        Set<String> set = keywordsMap.get(keywords);
        if (set.size()==0) System.out.println("Not Found");
        else {
            Iterator<String> iterator = set.iterator();
            while (iterator.hasNext()){
                System.out.println(iterator.next());
            }
        }
    }

    private static void queryAuthor(String author) {
        Set<String> set = authorMap.get(author);
        if (set.size()==0) System.out.println("Not Found");
        else {
            Iterator<String> iterator = set.iterator();
            while (iterator.hasNext()){
                System.out.println(iterator.next());
            }
        }
    }

    // The Testing Book
    private static void queryTitle(String title) {
        Set<String> set = titleMap.get(title);
        if (set.size()==0) System.out.println("Not Found");
        else {
            Iterator<String> iterator = set.iterator();
            while (iterator.hasNext()){
                System.out.println(iterator.next());
            }
        }
    }
}
