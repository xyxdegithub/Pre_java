import java.util.Arrays;
import java.util.Comparator;

/**
 * @author :xyx
 * @date :2021/2/4 16:37
 * @description:定制排序
 * @
 */
public class ComparatorTest {
    public static void main(String[] args) {
        String[] str = {"aa", "s", "AA", "df", "sc", "GG"};
        System.out.println(Arrays.toString(str));
        Arrays.sort(str, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1 instanceof String && o2 instanceof String) {
                    String s1 = o1;
                    String s2 = o2;
                    return -s1.compareTo(s2);//从大到小排序
                }
                throw new RuntimeException("输入类型不行!");
            }
        });
        System.out.println(Arrays.toString(str));
    }

}
