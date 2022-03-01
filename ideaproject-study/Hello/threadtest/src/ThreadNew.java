import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author :xyx
 * @date :2021/1/31 17:25
 * @description:创建线程方式
 * @
 */
class NewThread implements Callable {

    @Override
    public Object call() throws Exception {
        int sum = 0;
        for (int i = 1; i <= 100; i++) {
            if (i % 2 == 0) {
                System.out.println(i);
                sum += i;
            }
        }
        return sum;
    }
}

public class ThreadNew {
    public static void main(String[] args) {
        NewThread nt = new NewThread();
        //将实现callable接口实现类的对象作为参数传入futuretask构造器中,创建futuretask对象
        FutureTask futureTask = new FutureTask(nt);

        Thread thread = new Thread(futureTask);
        thread.start();
        try {
            Object sum = futureTask.get();//get方法返回值即为call方法返回值
            System.out.println(sum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }

}
