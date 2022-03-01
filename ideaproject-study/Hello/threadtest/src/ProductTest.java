

/**
 * @author :xyx
 * @date :2021/1/31 16:45
 * @description:线程通信示例，生产者和消费者问题
 * @
 */
//售货员
class Clerk {
    private int productNumber = 0;

    public synchronized void producerProduct() {
        if (productNumber < 20) {
            System.out.println(Thread.currentThread().getName() + "开始生产第" + (++productNumber) + "个产品");
            notify();
        } else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void consumerConsume() {
        if (productNumber > 0) {
            System.out.println(Thread.currentThread().getName() + "开始消费第" + (productNumber) + "个产品");
            productNumber--;
        } else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

//生产者
class Producer extends Thread {
    private Clerk clerk;

    public Producer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {

        System.out.println(Thread.currentThread().getName() + "生产者开始生产.......");
        while (true) {
            try {
                sleep(10);//控制生产速度
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.producerProduct();
        }
    }
}


//消费者
class Consumer extends Thread {
    private Clerk clerk;

    public Consumer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "消费者开始消费.......");
        while (true) {
            try {
                sleep(100);//控制消费速度
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.consumerConsume();
        }
    }
}

public class ProductTest {

    public static void main(String[] args) {
        Clerk clerk = new Clerk();
        Producer p = new Producer(clerk);
        Consumer c = new Consumer(clerk);
        p.setName("生产者:");
        c.setName("消费者:");
        p.start();
        c.start();
    }
}
