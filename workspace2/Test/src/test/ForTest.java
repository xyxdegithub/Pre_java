package test;

import java.util.Scanner;

public class ForTest {
	/*
	 * public static void ChengFaBiao() { // 打印一个99乘法表 for (int i = 1; i <= 9; i++)
	 * { // 控制乘法表行数 for (int j = 1; j <= i; j++) { System.out.print(j + "x" + i +
	 * "=" + j * i + "  "); } System.out.println(); } }
	 */

	/*
	 * public static void ZhengFangXing() { for (int i = 1; i < 5; i++) { for (int j
	 * = 1; j < i; j++) { System.out.print("*"); } System.out.println(); } }
	 */

	/*
	 * public static void For() { for (int i = 1; i < 5; i++) { System.out.print(i);
	 * for (int j = 1; j < 5; j++) { System.out.print(" "); } System.out.print(i);
	 * System.out.println(); } }
	 */
	// 求两个数的最大公约数,用for循环暴力
	public static void ZuiDaGYS(int m, int n) {
		int min = m < n ? m : n; // 获取两个数的最小值
		for (int i = min; i >= 1; i--) {
			if (m % i == 0 && n % i == 0) {
				System.out.println(m + "和" + n + "的最大公约数是:" + i);
				break;
			}
		}
	}

	// 求两个数最小公倍数
	public static void ZuiXiaoGBS(int m, int n) {
		int max = m > n ? m : n;
		for (int i = max; i <= m * n; i++) {
			if (i % m == 0 && i % n == 0) {
				System.out.println(m + "和" + n + "的最小公倍数是:" + i);
				break;
			}
		}
	}

	public static void main(String[] args) {
		/*
		 * ChengFaBiao(); ZhengFangXing(); For();
		 */
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入一个正数:");
		int m = sc.nextInt();
		System.out.println("请输入一个正数:");
		int n = sc.nextInt();
		ZuiDaGYS(m, n);
		ZuiXiaoGBS(m, n);
	}
}
