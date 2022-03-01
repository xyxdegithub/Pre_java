/**
 * @author :xyx
 * @date :2021/1/31 12:03
 * @description:两个储户分别往同一个账户存3000元钱，每次存1000，存三次。每次存完打印账户余额
 * @
 */
class Account {
    private double balance;

    public Account(double balance) {
        this.balance = balance;
    }

    public synchronized void deposit(int amt) {
        balance += amt;
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "存钱成功!" + "账户余额为" + balance + "元");

    }
}

class Customer extends Thread {
    private Account acc;

    public Customer(Account acc) {
        this.acc = acc;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            acc.deposit(1000);
        }
    }
}

public class AccountTest {
    public static void main(String[] args) {
        Account acc = new Account(0);
        Customer c1 = new Customer(acc);
        Customer c2 = new Customer(acc);
        c1.setName("甲");
        c2.setName("乙");
        c1.start();
        c2.start();
    }
}
