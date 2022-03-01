package com.a;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileTest {
/*
 * 实例将字符串写入一个文件
 * 
 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
        File file=new File("E:/Java/workspace/filetest.txt");
        FileWriter fw=new FileWriter(file);
        String s="Hello File";
        fw.write(s);
        fw.close();
	}

}
