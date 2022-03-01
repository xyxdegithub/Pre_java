package test;

import javax.sound.midi.SysexMessage;

public class ArrayTest3 {
	public static void f1() {
		int[][] a = new int[][] { { 1, 2, 3 }, { 4, 5 } };
		System.out.println(a.length);
		System.out.println(a[0].length);
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
			System.out.println(a[0]); // 地址值 System.out.println(a[0][0]);
		}
	}

	public static void f2() {
		int[][] a = new int[][] { { 3, 9 }, { 1, 12 } };
		int max = a[0][0];
		int min = a[0][0];
		int sum = 0, average = 0;
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				if (a[i][j] > max) {
					max = a[i][j];
				}
				if (a[i][j] < min) {
					min = a[i][j];
				}
				sum += a[i][j];
				average = sum / 4;
			}
		}
		System.out.println("数组的最大值是:" + max);
		System.out.println("数组的最小值是:" + min);
		System.out.println("数组的和是:" + sum);
		System.out.println("数组的平均值是:" + average);
	}

	public static void f3() {
		int[] a = new int[10];
		int max = a[0];
		int min = a[0];
		int sum = 0, average = 0;
		for (int i = 0; i < a.length; i++) {
			a[i] = (int) (Math.random() * 50); // 随机取0-49
		}
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		for (int i = 0; i < a.length; i++) {
			if (a[i] > max) {
				max = a[i];
			}
			if (a[i] < min) {
				min = a[i];
			}
		}

		System.out.println();
		System.out.println("数组的最大值是:" + max);
		System.out.println("数组的最小值是:" + min);
		System.out.println("数组的平均值是:" + average);
		System.out.println("数组的总和是:" + sum);

	}

	public static void main(String[] args) {
		int[] a = new int[10];
		for (int i = 0; i < a.length; i++) {
			a[i] = (int) (Math.random() * 50);
		}
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		//反转数组的值
		for (int i = 0; i < a.length / 2; i++) {
			int temp = a[i];
			a[i] = a[a.length - i - 1];
			a[a.length - i - 1] = temp;
		}
		System.out.println();
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}
}
