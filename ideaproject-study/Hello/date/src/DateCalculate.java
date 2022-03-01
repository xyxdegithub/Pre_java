import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * @author :xyx
 * @date :2021/1/27 19:03
 * @description:计算一个日期距今多少天,这程序并不完美
 * @
 */
public class DateCalculate {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        System.out.println("输入一个日期(格式为:如2018-4-18)");
        String str = sc.next();
        SimpleDateFormat simpledateformat = new SimpleDateFormat("yyyyy-MM-dd");
        Date inputDate = simpledateformat.parse(str);//把文本转化成日期格式
        long inpuTime = inputDate.getTime();//此方法返回类型是long
        Date nowDate = new Date();
        long nowTime = nowDate.getTime();
        long difference = nowTime - inpuTime;
        if (difference >= 0) {
            //输入日期已过
            long days = difference / 1000 / 60 / 60 / 24 ;
            System.out.println("输入的日期是" + days + "天前");
        } else {
            //输入日期还在未来
            difference = -difference;
            long days = difference / 1000 / 60 / 60 / 24 + 1;
            System.out.println("输入的日期是" + days + "天后");
        }
    }

}
