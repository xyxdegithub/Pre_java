/**
 * @author :xyx
 * @date :2021/1/20 20:26
 * StringBuffer可变安全效率低
 * StringBuilder可变不安全效率高
 * @
 */
public class StringBufferBuilderTest {
    public static void main(String[] args) {
        {
            //StringBuffer sb1="AMERICAGREATAGAIN";//不正确
            StringBuffer sb1 = new StringBuffer("pest");
            // System.out.println(sb1.setCharAt(0,'b'));
            sb1.setCharAt(0, 'b');
            System.out.println(sb1);//best,可变
            sb1.append(1223);
            System.out.println(sb1);//best1223
            //System.out.println(sb1.charAt(12));//String index out of range: 12
            System.out.println(sb1.charAt(1));//e
            System.out.println(sb1.length());//8
            System.out.println(sb1.append("dsadsakjdhsad"));
            StringBuffer sbu=new StringBuffer("abcdefghijklmnopqrmn");
            System.out.println(sbu);//abcdefghijklmnopqrmn

        }
        System.out.println("*********************************");
        StringBuilder sbu = new StringBuilder("StringBuilder");
        //StringBuilder sbu="as";不正确
        System.out.println(sbu);//StringBuilder


    }

}
