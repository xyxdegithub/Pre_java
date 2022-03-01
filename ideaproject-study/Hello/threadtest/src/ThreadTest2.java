/**
 * @author ：xyx
 * @date ：2021/1/19 14:36
 * @description：TODO
 */
public class ThreadTest2 {
    public static void main(String[] args) {
        MyThread1 thread1 = new MyThread1();
        MyThread2 thread2 = new MyThread2();
        thread1.setName("线程一");
        thread2.setName("线程二");
        System.out.println();
        thread1.start();//启动当前线程，调用当前线程run方法
        thread2.start();

    }

}

class MyThread1 extends Thread {
    @Override
    public void run() {

        for (int i = 0; i < 100; i++)
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ":" + i + "偶数");
            }
//                  if (i==20){
//                yield();
//            }
    }
}

class MyThread2 extends Thread {
    @Override
    public void run() {
      /*  //线程执行迟10秒
        try {
            sleep(10000);//线程加入阻塞状态
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        for (int i = 0; i < 100; i++) {
            if (i % 2 != 0) {
                System.out.println(Thread.currentThread().getName() + ":" + i + "奇数");
            }
            if (i == 21) {

            }
        }
    }
}
