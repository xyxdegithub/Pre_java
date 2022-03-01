import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalAccessor;

/**
 * @author :xyx
 * @date :2021/2/2 19:35
 * @description:datetimeformatter转化与解析,对比simpledateformat
 * @
 */
public class DateTimeTest7 {
    public static void main(String[] args) {
        System.out.println("**************一***************");
        //日期->字符串
        DateTimeFormatter isoLocalDateTime = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        LocalDateTime localDateTime = LocalDateTime.now();
        String str = isoLocalDateTime.format(localDateTime);
        System.out.println(localDateTime);
        System.out.println(str);
        //字符串到日期
        TemporalAccessor localDateTime1 = LocalDateTime.now();
        localDateTime1 = isoLocalDateTime.parse("2021-02-02T19:44:54.401");
        System.out.println(localDateTime1);//{},ISO resolved to 2021-02-02T19:44:54.401
        System.out.println("**************二***************");
        //日期到字符串
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG);
        DateTimeFormatter dateTimeFormatter1 = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM);
        DateTimeFormatter dateTimeFormatter2 = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);
        DateTimeFormatter dateTimeFormatter3 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG);
        DateTimeFormatter dateTimeFormatter4 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
        DateTimeFormatter dateTimeFormatter5 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);

        //LocalDateTime localDateTime2 = LocalDateTime.now();
        String str2 = dateTimeFormatter.format(localDateTime);
        String str3 = dateTimeFormatter1.format(localDateTime);
        String str4 = dateTimeFormatter2.format(localDateTime);
        String str5 = dateTimeFormatter3.format(localDateTime);
        String str6 = dateTimeFormatter4.format(localDateTime);
        String str7 = dateTimeFormatter5.format(localDateTime);
        System.out.println(str2);//2021年2月2日
        System.out.println(str3);//2021-2-2
        System.out.println(str4);//21-2-2
        System.out.println(str5);//2021年2月2日 下午07时58分48秒
        System.out.println(str6);//2021-2-2 19:58:48
        System.out.println(str7);//21-2-2 下午7:58

        //字符串到日期
        String str8 = dateTimeFormatter3.format(LocalDateTime.now());
        System.out.println(str8);//2021年2月2日 下午08时02分31秒
        System.out.println("**************三***************");
        //日期到字符串
        DateTimeFormatter dateTimeFormatter6 = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
        String str9 = dateTimeFormatter6.format(LocalDateTime.now());
        System.out.println(str9);//2021-02-02 08:08:46
        //字符串到日期
        TemporalAccessor temporalAccessor = dateTimeFormatter6.parse("2021-01-01 10:11:11");
        System.out.println(temporalAccessor);
    }

}
