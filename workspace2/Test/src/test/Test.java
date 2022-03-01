package test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Scanner;

/**
 * @author xyx 2021年1月13日 上午11:34:33
 */
public class Test {
	enum Size {
		small, medium, large, extra_large
	};// 自定义枚举类型

	public static void main(String[] args) {
		System.out.println((int) (Math.random() * 50));// 43
		//指定范围[min,max]
        //Math.random()*(max-min)+(min);

		int[] a1 = new int[10];
		int[] a2 = new int[] { 1 };
		System.out.println(a1);// [I@6d06d69c
		System.out.println(a2);// [I@7852e922
		char[] c = new char[] { 'a' };
		System.out.println(c);// a
		char a[] = { 0, 1, 2, 3, 4, 5 };
		char s[] = new char[10];
		int a3[][] = { { 1, 2 }, { 0 }, { 1, 2, 3 } };
		System.out.println(a3[1][0]);// 0
		char str[] = { '\0' };

		char c1 = 'a';
		System.out.println(c1);// a
		char c2 = 10;
		System.out.println(c2);// 空
		System.out.println((int) c2);// 10

		Integer a4 = 10;
		Integer a5 = 10;
		System.out.println(a4.equals(a5));// true;
		// 包装类和基本数据类型相互转化
		int i = 11;
		Integer i1 = new Integer(i);
		Integer i2 = new Integer(11);
		int i0 = i1.intValue();
		System.out.println(i0);// 11
		System.out.println(i1.equals(i2));// true
		Integer i3 = new Integer("110");
		System.out.println(i1.equals(i3));// fasle
		System.out.println(i3.toString());// 110

		System.out.println((int) Math.PI);// 3
		System.out.println(Math.pow(3, 2));// 9.0

		int n = 1234567890;
		System.out.println((float) n);// 1.23456794E9
		System.out.println(Math.round(2.66));// 3
		Test aTest = new Test();
		System.out.println(aTest.getClass());// class test.Test

		Size aSzie = Size.extra_large;

		String string = "I_Love";
		String s1 = string.substring(0, 1);
		System.out.println(s1);// I
		int age = 5;
		System.out.printf("我的年龄是%d", age);// 我的年龄是5
		System.out.printf("%tc", new Date());// 一月 16 16:31:03 CST 2021
		System.out.println("***************************");
		System.out.println(new Date());// Sat Jan 16 16:34:23 CST 2021
		System.out.printf("%tT", new Date());// 16:36:57
		System.out.println("***************************");
		System.out.printf("%tr", new Date());// 04:38:35 下午
		System.out.println("***************************");
		System.out.println("***************************");

		try {
			Scanner sc = new Scanner(new File("E:\\JavaCode\\file.txt"));
			String file = sc.next();// 一行
			System.out.println(file);
			PrintWriter pw = new PrintWriter("E:\\JavaCode\\inputfile.txt");
			pw.print(file);
			pw.flush();
			System.out.println("写入成功!");
		} catch (FileNotFoundException e) {
			System.out.println("找不到文件");
			e.printStackTrace();
		}

	}

}
