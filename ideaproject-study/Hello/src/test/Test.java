package test;

/**
 * @author :xyx
 * @date :2021/1/22 8:45
 * @description:测试类
 * @
 */
public class Test {
    static int i;
    public static void main(String[] args) {
        System.out.println(i);//0
        {
            System.out.println(Math.random());//0-1之间的数，不能为1,不能为0
            System.out.println("***************************************");
            //指定范围[min,max]
            //Math.random()*(max-min)+(min);
            for (int i = 0; i < 100; i++) {
                System.out.println((int) (Math.random() * (10)));
            }
        }
        {
            System.out.println("*****************************");
            //foreach循环,数据类型,局部变量,名称
            int[] a = {1, 2, 3, 4, 5};
            for (int i : a
            ) {
                System.out.println(i);
            }
        }
        {
            int a = 6;
            System.out.print(a);
            System.out.print(a++);
            System.out.print(a);
        }
//        {
//            System.out.println("******************************");
//            int i = 10;
//            while (i > 0) {
//                i = i + 1;
//                if (i == 10){
//                    break;
//                }
//                System.out.println(i);
//            }
      //  }
//        {
//            String str="ABCDE";
//            str.substring(3);
//            str.concat("XYZ");
//            System.out.println(str);
//        }
        {
            //String String="String";

        }

    }

}
