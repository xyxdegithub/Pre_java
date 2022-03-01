package demo;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.URL;

/**
 * @author :xyx
 * @date :2021/7/6 19:42
 * @description:爬今日头条的问题
 * @
 */
public class WebCrawlerToImg2 {
    public static void main(String[] args) throws IOException {

        Document document = Jsoup.parse(new URL
                ("https://www.toutiao.com/w/a1704494293365767/?wid=1625571509105"), 1000);
        System.out.println(document);
        Elements imgs = document.getElementsByTag("img");

        System.out.println(imgs);


    }

}
