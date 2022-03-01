package nodeStream;

import org.junit.Test;

import java.io.FileOutputStream;

/**
 * @author :xyx
 * @date :2021/5/24 11:23
 * @description:演示使用 字节流FileOutputStream 将数据写到文件中, 如果该文件不存在，则创建该文件
 * @
 */
public class WriteFile {

    @Test
    public void writeFile01() throws Exception {
        //当写入内容是，会覆盖原来的内容
        FileOutputStream fileOutputStream = new FileOutputStream
                ("E:\\javacode\\ideaproject\\Hello\\io\\file2.txt");
        fileOutputStream.write('b');
        fileOutputStream.close();
    }

    @Test
    public void writeFile02() throws Exception {
        //当写入内容是，是追加到文件后面
        FileOutputStream fileOutputStream = new FileOutputStream("file2.txt", true);
        fileOutputStream.write('a');
        String str="写入字节";
        //字符串变成字节数组
        byte[] bytes = str.getBytes();
        fileOutputStream.write(bytes);
        fileOutputStream.write(bytes,0,1);

    }
}
