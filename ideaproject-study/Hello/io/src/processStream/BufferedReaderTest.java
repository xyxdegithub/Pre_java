package processStream;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author :xyx
 * @date :2021/5/24 22:08
 * @description:在字节流上提高了效率
 * @
 */
public class BufferedReaderTest {
    @Test
    public void test() {
        String path = "file.txt";
        BufferedReader bufferedReader = null;
        String line; //按行读取, 效率高
        try {
            bufferedReader = new BufferedReader(new FileReader(path));
            while (((line = bufferedReader.readLine()) != null)) {
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}
