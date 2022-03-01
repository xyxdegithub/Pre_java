/**
 * @author :xyx
 * @date :2021/1/28 20:36
 * @description:把共享数据写成一个方法里，再加锁
 * @
 */
public class ThreadTest6 {
    public static void main(String[] args) {
        Windows3 w3 = new Windows3();
        Thread t1 = new Thread(w3);
        Thread t2 = new Thread(w3);
        Thread t3 = new Thread(w3);
        t1.setName("窗口一:");
        t2.setName("窗口二:");
        t3.setName("窗口三:");
        t1.start();
        t2.start();
        t3.start();
    }

}

class Windows3 implements Runnable {
    private static int tickets = 100;

    @Override
    public void run() {
        while (true) {
            sell();
        }
    }

    private static synchronized void sell() {
        if (tickets > 0) {
            System.out.println(Thread.currentThread().getName() + "买出" + tickets + "张票");
            tickets--;

        }

    }
}