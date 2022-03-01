package test;

import java.util.Scanner;

public class ForWhileTest {

	public static void main(String[] args) {
		// 从键盘读入n个不确定的整数，判断读入正数和负数的个数，读入0就结束程序
		Scanner sc = new Scanner(System.in);
		int positivecount = 0, negativecount = 0;
		System.out.println("请输入整数:");
		while (true) { // for(;;)
			int number = sc.nextInt();
			if (number > 0) {
				positivecount++;
			} else if (number < 0) {
				negativecount++;
			} else {
				// 一旦是0退出循环
				break;
			}
		}
		System.out.println("你输入的正数个数为" + positivecount + "!");
		System.out.println("你输入的负数个数为" + negativecount + "!");

	}

}
