/**
 * @author ：xyx
 * @date ：2021/1/19 12:00
 * @description：多线程示例
 */
public class ThreadTest {
    public static void main(String[] args) {
        //3.创建一个继承类的对像
        MyThread mythread = new MyThread();
        //设置线程执行优先级，设置为最大
        mythread.setPriority(Thread.MAX_PRIORITY);
        //4.由这对象调用start方法
        mythread.start();

        Thread.currentThread().setName("主线程");
        Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
        for (int i = 0; i < 100; i++) {
            if (i % 2 != 0) {
                System.out.println(Thread.currentThread().getName() + ":" + i); //main线程里输出，两个线程在执行,输出的结果看电脑了
            }
//            if (i == 21) {
//                //当i==21时，把另一个线程执行,此线程停止
//                try {
//                    mythread.join();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }

        }

    }

}

//1.创建一个继承与Thread类的子类
class MyThread extends Thread {
    //2.重写run方法,将此线程执行的操作写在run方法中
    @Override
    public void run() {
        //super.run();
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + i);
            }
        }
    }

}