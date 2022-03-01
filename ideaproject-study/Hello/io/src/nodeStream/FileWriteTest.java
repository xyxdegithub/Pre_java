package nodeStream;

import org.junit.Test;

import java.io.FileWriter;
import java.io.IOException;

/**
 * @author :xyx
 * @date :2021/5/24 20:01
 * @description:字符流用filewrite写入一定要close和flush
 * @write(char[]):写入指定数组   write(char[],off,len):写入指定数组的指定部分
 * write（string）：写入整个字符串   write(string,off,len):写入字符串的指定部分
 * 对应 FileWriter , 一定要关闭流，或者 flush 才能真正的把数据写入到文件
 */
public class FileWriteTest {

@Test
    public void test(){
    String path="file2.txt";
    int data=0;
    try {
        FileWriter fileWriter = new FileWriter(path,true);
        fileWriter.write("abb");
        fileWriter.flush();
        fileWriter.close();
    } catch (IOException e) {
        e.printStackTrace();
    }

}
}
