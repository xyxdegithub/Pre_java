import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/**
 * @author :xyx
 * @date :2021/1/20 16:22
 * @description:TODO
 * @
 */
public class StringMethodTest {
    public static void main(String[] args) throws UnsupportedEncodingException {
        {
            String str = " ";
            System.out.println(str.isEmpty());//false
            String str2 = "";
            System.out.println(str2.isEmpty());//true
            String str3 = "ilovemyfamily";
            System.out.println(str3.toUpperCase());//ILOVEMYFAMILY
            System.out.println(str3.toLowerCase());//ilovemyfamily
            String str4 = "  ab  c";
            String str5 = "   aaa    ";
            System.out.println(str5.compareTo(str4));//-1,字符串排序
            System.out.println(str4.charAt(0));//a
            System.out.println(str4.length());//3
            System.out.println(str4.trim());//ab  c,去除首尾空格
            System.out.println(str5.length());//10
            System.out.println(str5.trim());//aaa
        }
        System.out.println("*************************************");
        {
            String s1 = "abcdaefg";
            System.out.println(s1.substring(2, 3));//c,子串,左闭右开
            System.out.println(s1.substring(0,2));//ab
            System.out.println(s1.substring(4));//aefg
            System.out.println(s1.indexOf("a"));//0,返回字符串第一次出现的位置
            System.out.println(s1.indexOf("a", 0));//0
            //返回指定子字符串在此字符串中第一次出现处的索引，从指定的索引开始
            System.out.println(s1.indexOf("b", 1));//1
            System.out.println(s1.lastIndexOf("a"));//4,返回字符串最后一次出现的位置
            System.out.println(s1.lastIndexOf("a", 2));//0,从右往左
            System.out.println(s1.concat("efj"));//abcdefj
        }

        System.out.println("*************************************");
        {
            String s1 = "HelloWorld";
            System.out.println(s1.endsWith("ld"));//true
            System.out.println(s1.endsWith("d"));//true
            System.out.println(s1.startsWith("h"));//false,java区分大小写
            System.out.println(s1.startsWith("H", 0));//true,在0的位置以H开头
            System.out.println(s1.contains("ll"));//true
        }
        System.out.println("*************************************");
        {
            String s1 = "tigerandrabbit";
            System.out.println(s1.replace("rabbit", "cat"));//tigerandcat
            System.out.println("*****************转换*****************");
            String s2 = "abc123";
            char[] ch = s2.toCharArray();
            for (int i = 0; i < ch.length; i++) {
                System.out.print(ch[i] + " ");//a b c 1 2 3
            }
            System.out.println();
            char[] ch2 = {'S', 'U', 'N'};
            String s3 = new String(ch2);
            System.out.println(s3);//SUN
        }
        System.out.println("******************字节字符串转换*******************");
        {
            String s1 = "abc123中国";
            byte[] b1 = s1.getBytes(StandardCharsets.UTF_8);
            System.out.println(b1);//[B@1b6d3586
            System.out.println(Arrays.toString(b1));
            //[97, 98, 99, 49, 50, 51, -28, -72, -83, -27, -101, -67]ascii,编码
            byte[] b2 = s1.getBytes("gbk");
            System.out.println(Arrays.toString(b2));
            //[97, 98, 99, 49, 50, 51, -42, -48, -71, -6]
            String s2 = new String(b1);
            System.out.println(s2);//abc123中国,解码
            String s3 = new String(b2);
            System.out.println(s3);//乱码，编码不统一abc123�й�
            String s4 = new String(b2, "gbk");
            System.out.println(s4);//abc123中国

        }
    }

}
