/**
 * @author :xyx
 * @date :2021/1/20 11:10
 * @description:引用数据类型，看起来像基本数据类型
 * @直接赋值，不用new，字面量方式赋值
 */
public class StringTest {
    public static void main(String[] args) {
        {
            //在方法区，在常量池中
            String s1 = "abc";
            String s2 = "abc";
            //在堆中
            String s3 = new String("abc");
            String s4 = new String("abc");
            System.out.println(s1 == s2);//true ,比较s1和s2地址值
            System.out.println(s1 == s3);//false
            System.out.println(s1 == s4);//false
            System.out.println(s3 == s4);//false
            System.out.println(s3.equals(s4));//true
            System.out.println(s3.equals(new String("abc")));//true
        }
        System.out.println("*********************************");
        {
            //堆和常量池的区别
            String s1 = "Hello";
            String s2 = "World";
            String s3 = "HelloWorld";
            String s4 = "Hello" + "World";
            String s5 = s1 + "World";
            String s6 = "Hello" + s2;
            String s7 = s1 + s2;
            String s8 = s5.intern();
            String s9 = s3.intern();
            //intern()方法返回常量池
            //比的都是地址
            System.out.println(s1 == s2);//false
            System.out.println(s3 == s4);//true
            System.out.println(s3 == s5);//false
            System.out.println(s3 == s6);//false
            System.out.println(s3 == s7);//false
            System.out.println(s5 == s6);//false
            System.out.println(s4 == s7);//false
            System.out.println(s5 == s8);//false
            System.out.println(s3 == s9);//true

        }
        System.out.println("*********************************");
        {
            //包装类与基本数据类型，不同类型转换
            String str = "123";
            int i = Integer.parseInt(str);
            System.out.println(i);//123
            String str2 = String.valueOf(i);
            System.out.println(str2);//123
        }

    }
}
