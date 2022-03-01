package demo;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * @author :xyx
 * @date :2021/6/24 19:32
 * @description:从网络上爬图片,在确定的网址上
 * @
 */
public class WebCrawlerToImg {

    public static void main(String[] args) throws IOException {

        String url = "https://mp.weixin.qq.com/s/nU_zrzJgBDe49kH55sZcyw";
        Document document = Jsoup.parse(new URL(url), 10000);
        //用浏览器开发者工具观察源代码，找到父节点
        Element element = document.getElementById("js_content");
        //确定要爬的标签,在上面id下的所有img标签
        Elements imgs = element.getElementsByTag("img");
        System.out.println(imgs);
        int id = 0;
        for (Element img :
                imgs) {
            String imgUrlStr = img.attr("data-src");
            //把字符串变成网址
            URL imgUrl = new URL(imgUrlStr);
            URLConnection urlConnection = imgUrl.openConnection();
            //得到输入流
            InputStream inputStream = urlConnection.getInputStream();

            int temp = 0;
            id++;
            //确定输出位置
            OutputStream outputStream = new FileOutputStream("C:\\Users\\xyx\\Desktop\\" + id + ".png");
            //就是最简单复制文件的思想
            while ((temp = inputStream.read()) != -1) {
                outputStream.write(temp);
            }
            inputStream.close();
            outputStream.close();
        }

        System.out.println("该网址上的所有图片下载完毕");
    }
}
