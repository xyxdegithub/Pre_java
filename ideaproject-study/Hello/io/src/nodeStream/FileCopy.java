package nodeStream;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * @author :xyx
 * @date :2021/5/24 11:32
 * @description:copy简单的理解就是一边读一边写
 * @
 */
public class FileCopy {
    @Test
    public void fileCopy() throws Exception {
        FileInputStream fileInputStream = new FileInputStream
                ("E:\\javacode\\ideaproject\\Hello\\io\\file.txt");

        FileOutputStream fileOutputStream = new FileOutputStream
                ("E:\\javacode\\ideaproject\\Hello\\io\\copy.txt", true);

        byte[] bytes = new byte[1024];
        int readLen = 0;
        while ((readLen = fileInputStream.read(bytes)) != -1) {
            System.out.println("复制了" + readLen + "个字节");
            //写入指定数组的指定部分
            fileOutputStream.write(bytes, 0, readLen);
        }
        System.out.println("成功复制！");
        fileOutputStream.close();
        fileInputStream.close();

    }

}
