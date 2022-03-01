/**
 * 
 */
package test;

/**
 * @author xyx 2021年1月14日 下午4:15:02 单例模式的测试 1.私有的构造方法 2.类中生成新对象,静态
 *         3.提供公共方法返回对象,静态 饿汉式和懒汉式
 */
public class SingletonTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Bank bank1 = Bank.getBank();
		Bank bank2 = Bank.getBank();
		System.out.println(bank1 == bank2);// true

	}

}

class Bank {

	private Bank() {

	}

	private static Bank bank = new Bank();

	// peiavte static Bank bank=null;
	public static Bank getBank() {
		return bank;
	}
	/*
	 * public static Bank getBank() { if(bank==null) { bank=new Bank(); } return
	 * bank; }
	 */
}
