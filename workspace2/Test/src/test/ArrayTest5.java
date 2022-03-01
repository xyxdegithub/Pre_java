package test;

import java.util.Arrays;

public class ArrayTest5 {

	public static void main(String[] args) {
		int[] a = new int[] { 10, 12, 2, 4, 22 };
		boolean flag = true;
		for (int i = 0; i < a.length - 1; i++) {
			for (int j = 0; j < a.length - 1 - i; j++) {
				if (a[j] < a[j + 1]) { // 决定从小到大还是从大到小
					int temp = a[j + 1];
					a[j + 1] = a[j];
					a[j] = temp;
				}
			}
		}
		System.out.println(Arrays.toString(a));
	}

}
