package polymorphism;

/**
 * @author xyx 2021年1月12日 下午3:15:49 多态的实现一定要有继承关系
 * 多态是运行时行为
 */
public class Test {
	public static void main(String[] args) {
		Person p1 = new Man();
		p1.age = 22;
		p1.eat();// 这是父类中的方法，运行的是子类的，编译看左边，运行右边
		Man m1=(Man)p1;
		m1.eat();
		System.out.println(p1.id);// 这是父类的
	}
}
