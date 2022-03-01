/**
 * @author :xyx
 * @date :2021/1/21 10:23
 * @description:StringBuffer和StringBuilder常用方法
 * @
 */
public class StringBufferBuilderTest2 {
    public static void main(String[] args) {
        {
            StringBuffer sb = new StringBuffer("StringBuffer");
            sb.insert(0, sb);
            System.out.println(sb);//StringBufferStringBuffer
            sb.replace(0, 6, "Hello");
            System.out.println(sb);//HelloBufferStringBuffer
            //sb.codePointAt(1);
            System.out.println(sb.reverse());//reffuBgnirtSreffuBolleH,反转

            System.out.println("********************************************");

        }
    }

}
