import java.util.Arrays;

/**
 * @author :xyx
 * @date :2021/2/2 21:05
 * @description:比较对象大小 comparable和comparator
 * @
 */
public class CompareTest {
    public static void main(String[] args) {
        String[] str = new String[]{"GG", "AA", "aa", "DD", "ff"};
        Arrays.sort(str);//排序,实现了comparable接口,重写了compareto方法
        System.out.println(Arrays.toString(str));//[AA, DD, GG, aa, ff]
    }

}
