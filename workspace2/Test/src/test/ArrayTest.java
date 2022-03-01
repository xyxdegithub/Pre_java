package test;

import java.util.Arrays;

/**
 * @author xyx 2021年1月9日 上午11:06:18
 */
public class ArrayTest {

	public static void main(String[] args) {
		// int[] a;
		// 静态初始化，赋值了 int[][] a=new int[][]{{1,2,3},{1,3}};
		String[] a = new String[] { "h", "e", "l", "l", "o" };
		System.out.println(Arrays.toString(a));
		System.out.println(a.length);

	}
}
