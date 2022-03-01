package test;

import java.util.Scanner;

public class ArrayTest4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 实现二分查找,有序的
		
		Scanner sc = new Scanner(System.in);
//		while (true) {
			int[] a = new int[] { 1, 6, 8, 9, 10, 11, 23, 24, 26, 56 };
			int low = 0, high = a.length - 1;
			boolean flag = true;
			System.out.println("请输入要查找的数字:");
			int find = sc.nextInt();
			while (low <= high) {
				int middle = (low + high) / 2;
				if (find == a[middle]) {
					System.out.println("找到了,位置在第" + (middle + 1) + "位");
					flag = false;
					break;
				} else if (find > a[middle]) {
					low = middle + 1;
				} else {
					high = middle - 1;
				}
			}
			if (flag) {
				System.out.println("遗憾,没找到!");
			}
//		}
	}
}