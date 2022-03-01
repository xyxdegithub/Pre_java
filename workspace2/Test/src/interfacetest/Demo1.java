package interfacetest;

/**
 * @author xyx 2021年1月16日 上午11:58:08
 */
interface A {
	int x = 0;
}

abstract class B {

	int x = 1;

}

public class Demo1 extends B implements A {
	public void output() {
		System.out.println(A.x);
		System.out.println(super.x);
	}

	public static void main(String[] args) {
		Demo1 demo = new Demo1();
		demo.output();
	}
}
