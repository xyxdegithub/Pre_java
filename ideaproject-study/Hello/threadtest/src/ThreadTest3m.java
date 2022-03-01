

/**
 * @author :xyx
 * @date :2021/1/28 18:35
 * @description:TODO
 * @
 */
public class ThreadTest3m {
    public static void main(String[] args) {
        Windowsm wm1 = new Windowsm();
        Windowsm wm2 = new Windowsm();
        Windowsm wm3 = new Windowsm();
        wm1.setName("窗口一:");
        wm2.setName("窗口二:");
        wm3.setName("窗口三:");
        wm1.start();
        wm2.start();
        wm3.start();
    }

}

class Windowsm extends Thread {
    private static int tickets = 100;
    private static Object obj = new Object();

    @Override
    public void run() {
        //synchronized(Windowsm.class)
        synchronized (obj) {
            while (true) {
                if (tickets > 0) {
                    System.out.println(getName() + "卖出一张票" + "是" + "第" + tickets + "张");
                    tickets--;
                } else {
                    break;
                }
            }
        }
    }
}
