

/**
 * @author :xyx
 * @date :2021/2/1 19:03
 * @description:将字符串指定部分进行反转，比如“abcdefg”反转为"abfedcg"
 * @string类没有reverse方法
 */
public class StringDemo {
    public static String reverse(String str, int startIndex, int endIndex) {
        if (str != null) {
            char[] c = str.toCharArray();
            //写这种循环的语法
            for (int i = startIndex, j = endIndex; i < j; i++, j--) {
                char temp = c[i];
                c[i] = c[j];
                c[j] = temp;
            }
            String s = new String(c);//string类构造方法
            return s;
        } else {
            return null;
        }
    }

    public static String reverse2(String str, int startIndex, int endIndex) {
        String s = str.substring(0, startIndex);//左闭右开
        for (int i = endIndex; i >= startIndex; i--) {
            s += str.charAt(i);
        }
        s += str.substring(endIndex + 1);//从endindex+1位置到最后
        return s;
    }

    public static void main(String[] args) {
        String str = "abcdefg";
        System.out.println(str);
        String reverse = reverse(str, 2, 5);
        System.out.println(reverse);
        String reverse2 = reverse2(str, 2, 5);
        System.out.println(reverse2);


    }

}
