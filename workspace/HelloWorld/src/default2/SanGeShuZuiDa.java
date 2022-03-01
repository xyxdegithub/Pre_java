package default2;

import java.util.Scanner;

public class SanGeShuZuiDa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		System.out.println("请输入第一个整数:");
		int a = sc.nextInt();
		System.out.println("请输入第二个整数:");
		int b = sc.nextInt();
		System.out.println("请输入第三个整数:");
		int c = sc.nextInt();

		/* int max = a > b ? a : b; max = max > c ? max : c; */

		int max = a > b ? (a > c ? a : c) : (b > c ? b : c);
		System.out.println("这三个数最大值是:" + max);
	}
}
