import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author :xyx
 * @date :2021/2/1 23:22
 * @description:simpledateformat类的使用，日期格式转换，string到日期
 * @
 */
public class DateTimeTest2 {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();//空参构造器

        System.out.println("**********日期格式化**********");
        Date date = new Date();
        System.out.println(date);//Mon Feb 01 23:28:24 CST 2021
        String format = simpleDateFormat.format(date);
        System.out.println(format);//21-2-1 下午11:28
        //指定格式化，有参构造器
        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy-MM-dd hh-mm-ss");

        String format1 = simpleDateFormat1.format(date);
        System.out.println(format1);

        System.out.println("**********字符串到日期**********");
        String str = "21-2-1 下午11:28";
        System.out.println(str);
        Date date1 = simpleDateFormat.parse(str);
        System.out.println(date1);//默认格式解析


    }

}
