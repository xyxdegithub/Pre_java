/**
 * @author :xyx
 * @date :2021/1/29 14:42
 * @description:死锁示例
 * @
 */
public class ThreadTest7 {
    public static void main(String[] args) {
        StringBuffer str1 = new StringBuffer();
        StringBuffer str2 = new StringBuffer();

        //一个线程
        new Thread() {
            @Override
            public void run() {
                synchronized (str1) {
                    str1.append("a");
                    str2.append("1");
                    try {
                        sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "执行到此");
                    synchronized (str2) {
                        str1.append("b");
                        str2.append("2");
                        System.out.println(Thread.currentThread().getName() + ":" + str1);
                        System.out.println(Thread.currentThread().getName() + ":" + str2);
                    }
                }

            }
        }.start();
//有一个线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (str2) {
                    str1.append("c");
                    str2.append("3");
                    System.out.println(Thread.currentThread().getName() + "执行到此");
                    synchronized (str1) {
                        str1.append("d");
                        str2.append("4");
                        System.out.println(Thread.currentThread().getName() + ":" + str1);
                        System.out.println(Thread.currentThread().getName() + ":" + str2);

                    }
                }
            }
        }).start();

    }
}
