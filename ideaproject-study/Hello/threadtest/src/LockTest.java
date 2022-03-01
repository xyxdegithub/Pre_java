import java.util.concurrent.locks.ReentrantLock;

/**
 * @author :xyx
 * @date :2021/1/29 16:09
 * @description:用ReentrantLock解决线程安全问题
 * @
 */
public class LockTest {
    public static void main(String[] args) {
        Windows4 w4 = new Windows4();
        Thread t1 = new Thread(w4);
        Thread t2 = new Thread(w4);
        Thread t3 = new Thread(w4);
        t1.setName("窗口一");
        t2.setName("窗口二");
        t3.setName("窗口三");
        t1.start();
        t2.start();
        t3.start();

    }

}

class Windows4 implements Runnable {
    private static int tickets = 100;
    ReentrantLock lock = new ReentrantLock(true);

    @Override
    public void run() {
        while (true) {
            try {
                lock.lock();
                if (tickets > 0) {
                    System.out.println(Thread.currentThread().getName() + "卖" + tickets + "张票");
                    tickets--;
                } else {
                    break;
                }
            } finally {
                lock.unlock();
            }

        }
    }
}
