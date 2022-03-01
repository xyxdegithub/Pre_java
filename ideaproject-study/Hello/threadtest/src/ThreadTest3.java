/**
 * @author ：xyx
 * @date ：2021/1/19 16:37
 * @description：创建多线程窗口卖票
 */
public class ThreadTest3 {
    public static void main(String[] args) {
        Windows w1 = new Windows();
        Windows w2 = new Windows();
        Windows w3 = new Windows();
        w1.setName("窗口一");
        w2.setName("窗口二");
        w3.setName("窗口三");
        w1.start();
        w2.start();
        w3.start();


    }

}

class Windows extends Thread {
    private static int ticket = 100;//三个进程共享静态变量,只会存在一个ticket

    @Override
    public void run() {

        while (true) {
            if (ticket > 0) {
                System.out.println(getName() + "卖出一张票" + "是" + "第" + ticket + "张");
                ticket--;

            } else {
                break;
            }

        }
    }
}
