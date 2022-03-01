

/**
 * @author :xyx
 * @date :2021/1/31 12:32
 * @description:用两个线程打印1-100整数，交替打印，线程通信示例
 * @wait,notify,notifyall必须使用在同步代码块或同步方法中
 * sleep和wait方法一旦执行就可以使当前线程加入阻塞状态
 * thread类sleep和object类中wait,wait会释放同步监视器
 */
class Number implements Runnable {
    private static int number = 1;

    @Override
    public void run() {
        while (true) {

            synchronized (this) {
                notify();//一个线程把另一个wait()的线程唤醒
                if (number <= 100) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + ":" + number);
                    number++;
                    try {
                        //使用wait()方法的线程加入阻塞状态，会释放锁
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    break;
                }
            }

        }
    }
}

public class CommunicationTest {
    public static void main(String[] args) {
        Number number = new Number();
        Thread t1 = new Thread(number);
        Thread t2 = new Thread(number);
        t1.setName("线程一:");
        t2.setName("线程二:");
        t1.start();
        t2.start();
    }

}
