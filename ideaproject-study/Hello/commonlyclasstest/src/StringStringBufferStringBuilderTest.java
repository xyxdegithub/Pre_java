/**
 * @author :xyx
 * @date :2021/1/21 10:36
 * @description:比较三类效率
 * @
 */
public class StringStringBufferStringBuilderTest {
    public static void StringTest() {
        long start = System.currentTimeMillis();
        String text = "";
        for (int i = 0; i < 20000; i++) {
            text += i;
        }
        long end = System.currentTimeMillis();
        System.out.println("String用时:" + (end - start) + "毫秒");


    }

    public static void StringBufferTest() {
        long start = System.currentTimeMillis();
        StringBuffer sb = new StringBuffer("");
        for (int i = 0; i < 20000; i++) {
            sb = sb.append(String.valueOf(i));
        }
        long end = System.currentTimeMillis();
        System.out.println("StringBuffer用时:" + (end - start) + "毫秒");

    }

    public static void StringBuilderTest() {
        long start = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < 20000; i++) {
            sb = sb.append(String.valueOf(i));
        }
        long end = System.currentTimeMillis();
        System.out.println("StringBuilder用时:" + (end - start) + "毫秒");

    }

    public static void main(String[] args) {
        StringTest();
        StringBufferTest();
        StringBuilderTest();
        System.out.println("效率:" + "StringBuilder>" + "StringBuffer>" + "String");

    }

}
