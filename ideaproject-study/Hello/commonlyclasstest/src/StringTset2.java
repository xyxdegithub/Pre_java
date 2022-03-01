/**
 * @author :xyx
 * @date :2021/1/20 14:40
 * @description:一道面试题
 * @
 */
public class StringTset2 {
    String str = "Hello";//引用类型
    char[] ch = {'a', 'b', 'c'};//基本类型


    public void change(String str, char[] ch) {//string复过去，string不可变,数组可变
        str = "World";
        ch[0] = 'b';

    }

    public static void main(String[] args) {
        StringTset2 test = new StringTset2();
        test.change(test.str, test.ch);
        System.out.println(test.str);//Hello
        System.out.println(test.ch);//bbc
        {
            System.out.println("*********");
            String s=" ";
            System.out.println(s.length());//1
            String str="";
            System.out.println(str.length());//0
        }
    }
}
