package demo;

import java.io.*;

/**
 * @author :xyx
 * @date :2021/7/10 8:26
 * @description:把输入在控制台的九九乘法表输出到文件中
 * @
 */
public class JiuJiu {
    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\xyx\\Desktop\\九九乘法表.txt");
        file.createNewFile();
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        PrintStream printStream = new PrintStream(fileOutputStream);
        System.setOut(printStream);//把控制台信息输入到文件中
        System.out.println("**********九九乘法表**********");
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(i + "x" + j + "=" + i * j + "\t");
            }
            System.out.println();
        }

    }

}
