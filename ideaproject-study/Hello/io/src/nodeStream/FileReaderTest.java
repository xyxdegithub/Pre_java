package nodeStream;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author :xyx
 * @date :2021/5/24 19:51
 * @description:字符流
 * @
 */
public class FileReaderTest {


    @Test
    public void test() {
        String path = "E:\\javacode\\ideaproject\\Hello\\io\\file.txt";
        int data = 0;
        try {
            java.io.FileReader fileReader = new java.io.FileReader(path);
            while ((data = fileReader.read()) != -1) {
                System.out.print((char) data);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
