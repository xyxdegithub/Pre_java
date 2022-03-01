package processStream;

import org.junit.Test;

import java.io.*;

/**
 * @author :xyx
 * @date :2021/5/25 9:36
 * @description:使用bufferedinputstream和bufferedoutputstream 复制视频，图片和音频
 * @stream的一般是字节流
 */
public class BufferedStreamCopyTest {
    @Test
    public void test() {
        String imgPath = "C:\\Users\\xyx\\Pictures\\Camera Roll\\人像\\小柯.jpg";
        String musicPath = "C:\\Users\\xyx\\Downloads\\song\\【明天會更好 Tomorrow Will Be Better】Official Music Video.mp3";
        String videoPath = "D:\\迅雷下载\\想见你·台版\\想见你大结局 独家彩蛋.mp4";
        String destPath = "C:\\Users\\xyx\\Desktop\\copy\\1.mp3";

        BufferedInputStream bufferedInputStream = null;
        BufferedOutputStream bufferedOutputStream = null;
        try {
            bufferedInputStream = new BufferedInputStream(new FileInputStream(musicPath));
            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(destPath));
            byte[] bytes = new byte[1024];
            int len = 0;
            while ((len = bufferedInputStream.read(bytes)) != -1) {
                bufferedOutputStream.write(bytes, 0, len);
            }
            System.out.println("拷贝完成!");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedInputStream.close();
                bufferedOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}
