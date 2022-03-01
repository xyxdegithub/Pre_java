import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author :xyx
 * @date :2021/1/31 18:38
 * @description:用线程池创建线程
 * @
 */
class Rthread implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + ":" + i);
        }
    }
}

class Cthread implements Callable {

    @Override
    public Object call() throws Exception {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + ":" + i);
        }
        return null;
    }
}

public class ThreadPoolTest {


    public static void main(String[] args) {
        //造一个线程池有10个线程
        ExecutorService service = Executors.newFixedThreadPool(10);
        System.out.println(service.getClass());//class java.util.concurrent.ThreadPoolExecutor

        service.execute(new Rthread());//适合使用runnable
        service.submit(new Cthread());//适合适用于callable

        service.shutdown();//关闭连接池
    }

}
