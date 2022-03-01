package com.a;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Writer;
import java.util.Scanner;

public class FileOut {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 从控制台读取数据
		Scanner scanner = new Scanner(System.in);
		String s;
		s = scanner.nextLine();
		// 定义一个写入对象
		FileWriter fw;
		// 一个疑问为什么要用suuround with而抛出异常不行
		try {
			fw = new FileWriter("E:/Java/workspace/filetest2.txt");
			fw.write(s);
			fw.flush();
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
