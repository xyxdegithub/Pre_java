package processStream;

import org.junit.Test;

import java.io.*;

/**
 * @author :xyx
 * @date :2021/5/24 22:22
 * @description:reader和write一般对字符进行操作，对音乐等文件不适合
 * @
 */
public class BufferedCopyTest {

    @Test
    public void test() {
        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;
        String path = "C:\\Users\\xyx\\Desktop\\新建文本文档.txt";
        String copyPath = "新建文本文档.txt";
        String line = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(path));
            bufferedWriter = new BufferedWriter(new FileWriter(copyPath));
            while ((line = bufferedReader.readLine()) != null) {
                bufferedWriter.write(line);
                //在新的一行
                bufferedWriter.newLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedReader.close();
                bufferedWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
