/**
 * @author ：xyx
 * @date ：2021/1/19 17:08
 * @description:实现多线程方法二
 */

public class ThreadTest4 {
    public static void main(String[] args) {
        //2.创建对象
        MyThread3 test3 = new MyThread3();
        //3.把对象传入thread构造器
        Thread t = new Thread(test3);

        //4.thread对象调用start方法
        t.start();
    }

}

//1.创建一个实现runnable接口的类
class MyThread3 implements Runnable {


    @Override
    public void run() {
        int count = 0;
        Thread.currentThread().setName("MyThread3");
        System.out.println(Thread.currentThread().getName());
        System.out.println("实现多线程的第二种方法!永实现runnable接口");
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.print(i + "\t");
                count++;
            }
            if (count == 5) {
                System.out.println();
                count=0;
            }
        }
    }
}
