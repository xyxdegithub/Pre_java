package processStream;

import org.junit.Test;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author :xyx
 * @date :2021/5/24 22:16
 * @description:TODO
 * @
 */
public class BufferedWriteTest {

    @Test
    public void test() {
        String path = "file2.txt";
        BufferedWriter bufferedWriter = null;
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(path,true));
            bufferedWriter.write("这里是bufferedWrite");
            bufferedWriter.write("cg");
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
