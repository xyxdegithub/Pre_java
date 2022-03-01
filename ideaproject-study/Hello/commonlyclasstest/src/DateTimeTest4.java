import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * @author :xyx
 * @date :2021/2/2 13:48
 * @description:练习,从2021-1-1开始，三天打鱼两天晒网的规律，计算xxxx-xx-xx是在打鱼还是在晒网。
 * @
 */
public class DateTimeTest4 {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个日期:(格式为yyyy-mm-dd)");
        String dateStr = sc.next();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

        String startDate = "2021-1-1";
        Date staDate = simpleDateFormat.parse(startDate);
        long staTime = staDate.getTime();

        Date inDate = simpleDateFormat.parse(dateStr);
        long inTime = inDate.getTime();

        long difference = inTime - staTime;
        //计算天数是个要思考的事情
        long days = difference / 1000 / 60 / 60 / 24 + 1;//不足一天的毫秒数算一天
        if (days % 5 == 0 || days % 5 == 4) {
            System.out.println("在晒网");
        }
        if (days % 5 == 1 || days % 5 == 2 || days % 5 == 3) {
            System.out.println("在打鱼");

        }

    }
}
