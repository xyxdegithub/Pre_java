package nodeStream;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author :xyx
 * @date :2021/5/24 10:39
 * @description:字节流读取文件的实例
 * @
 */
public class ReadFile {

    @Test
    //一个个字节的读取，效率比较低
    public void readFile01() {
        //设置读取文件的路径
        //绝对路径
        String path = "E:\\javacode\\ideaproject\\Hello\\io\\file.txt";
        //相对路径
        String path2 = "file.txt";
        //生成输入流对象
        FileInputStream fileInputStream1 = null;
        FileInputStream fileInputStream2 = null;
        int readData1 = 0;
        int readData2 = 0;
        try {
            fileInputStream1 = new FileInputStream(path);
            fileInputStream2 = new FileInputStream(path2);
            //循环读取
            while ((readData1 = fileInputStream1.read()) != -1) {
                System.out.print(readData1 + " ");
                System.out.print((char) readData1 + " ");
            }
            System.out.println();
            while ((readData2 = fileInputStream2.read()) != -1) {
                System.out.print(readData2 + " ");
                System.out.print((char) readData2 + " ");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                //关闭文件流，释放资源
                fileInputStream1.close();
                fileInputStream2.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    @Test
    //使用 read(byte[] b) 读取文件，提高效率
    //一个汉字三个字节
    public void readFile02() throws Exception {
        File file = new File("E:\\javacode\\ideaproject\\Hello\\io\\file.txt");
        FileInputStream fileInputStream = new FileInputStream
                (file);
        //字节数组，一次读取指定个字节
        byte[] buf = new byte[(int) file.length()];
        System.out.println(file.length());
        int readLen = 0;
        while ((readLen = fileInputStream.read(buf)) != -1) {
            System.out.println(readLen);
            System.out.println(new String(buf, 0, readLen));
        }
        fileInputStream.close();


    }
}
