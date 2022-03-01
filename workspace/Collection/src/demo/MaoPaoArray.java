package demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class MaoPaoArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] a = { 1, -2, 6, 5, 3, -9, 10, 8 };
		MaoPao(a);
		System.out.println(Arrays.toString(a));
	/*	for(int i=0;i<6;i++) {
			System.out.println(i);
		}*/
	}
	

	public static void MaoPao(int[] a) {
		int i = 0;
		int temp;
		for (i = 0; i < a.length; i++) {
			boolean flag = true;//加了boolean判断程序更加优化
			for (int j = 0; j < a.length - 1 - i; j++) {
				if (a[j] > a[j + 1]) {
					temp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = temp;
				}
				flag = false;
			}
			if (flag) {
				break;
			}
		}
	}

}
