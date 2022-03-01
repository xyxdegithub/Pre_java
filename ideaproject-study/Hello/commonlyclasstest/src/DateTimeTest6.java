import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

/**
 * @author :xyx
 * @date :2021/2/2 18:24
 * @description:instant类使用
 * @
 */
public class DateTimeTest6 {

    public static void main(String[] args) {
        Instant instant = Instant.now();
        //本初子午线对应的标准时间
        System.out.println(instant);//2021-02-02T10:39:36.849Z
        //添加时间偏移量
        OffsetDateTime offsetDateTime = instant.atOffset(ZoneOffset.ofHours(8));
        System.out.println(offsetDateTime);//2021-02-02T18:41:17.478+08:00
        //自1970年1月1日0时0分0秒
        System.out.println(instant.getEpochSecond());//获取秒数
        System.out.println(instant.toEpochMilli());//获取毫秒数
        //获取指定毫秒数的日期时间
        Instant instant1 = Instant.ofEpochMilli(1612262670040L);
        System.out.println(instant1);//2021-02-02T10:44:30.040Z
    }
}
