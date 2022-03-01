package oop;

public class FibonacciTest {
	/*
	 * 递归 *
	 * 
	 * * 斐波那契数列第几项,从第0项开始（1、1、2、3、5、8、13）
	 */

	public static int Fibonacci(int n) {
		if (n == 0) {
			return 1;
		} else if (n == 1) {
			return 1;
		} else {
			return Fibonacci(n - 1) + Fibonacci(n - 2);
		}
	}

	public static int Fibonacci2(int n) {

		return n > 2 ? Fibonacci(n - 1) + Fibonacci(n - 2) : 1;
	}

	// 输出斐波那契数列前n项的值
	public static void Traverse(int n) {
		for (int i = 0; i <= n; i++) {
			System.out.print(Fibonacci(i) + " ");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Fibonacci2(0));
		System.out.println(Fibonacci2(4));
		Traverse(5);
	}

}
