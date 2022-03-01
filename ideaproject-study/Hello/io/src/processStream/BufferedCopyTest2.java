package processStream;

import org.junit.Test;

import java.io.*;

/**
 * @author :xyx
 * @date :2021/5/24 22:54
 * @description:TODO
 * @
 */
public class BufferedCopyTest2 {


    @Test
    public void test() {
        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;
        String path = "C:\\Users\\xyx\\Desktop\\新建文本文档.txt";
        String copyPath = "C:\\Users\\xyx\\Desktop\\新建文本文档.txt";
        if (path.equals(copyPath)) {
            copyPath = "C:\\Users\\xyx\\Desktop\\新建文本文档-副本.txt";
        }
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
