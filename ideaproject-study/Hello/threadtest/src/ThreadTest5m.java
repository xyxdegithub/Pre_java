/**
 * @author :xyx
 * @date :2021/1/28 13:51
 * @description:TODO
 * @
 */
public class ThreadTest5m {
    public static void main(String[] args) {
        Windows2 w2 = new Windows2();//只有一个windows2对象
        Thread t1 = new Thread(w2);
        Thread t2 = new Thread(w2);
        Thread t3 = new Thread(w2);
        t1.setName("窗口一:");
        t2.setName("窗口二:");
        t3.setName("窗口三:");
        t1.start();
        t2.start();
        t3.start();
    }


}

class Windows2 implements Runnable {
    private static int tickets = 100;
    Object obj = new Object();


    @Override
    public void run() {
        //加锁保护线程安全，同步代码块，同步监视器，一个对象盯着
        //synchronized(this)
        synchronized (obj) {
            while (true) {
                if (tickets > 0) {
                    System.out.println(Thread.currentThread().getName() + ":" + "卖出一张票" + "是" + "第" + tickets + "张");
                    tickets--;
                } else {
                    break;
                }
            }
        }
    }
}