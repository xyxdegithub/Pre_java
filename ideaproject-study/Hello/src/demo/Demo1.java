package demo;

/**
 * @author :xyx
 * @date :2021/1/23 21:14
 * @description:笨方法，一个数一个数验证是不是质数
 * @
 */
public class Demo1 {
    public static void main(String[] args) {

        int count = 0;
        int count2 = 0;
        for (int i = 2; i < 100; i++) {
            boolean flag = true;//每一次循环重置flag为true

            //  for (int j = 2; j < i; j++) {
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    flag = false;
                    break;//如果不是素数就停止
                }
            }
            if (flag == true) {
                System.out.print(i + "\t");//输出质数
                count++;
                count2++;
            }
            if (count2 == 5) {
                System.out.println();
                count2 = 0;
            }

        }
        System.out.println("100内的质数有:" + count + "个");
    }

}
