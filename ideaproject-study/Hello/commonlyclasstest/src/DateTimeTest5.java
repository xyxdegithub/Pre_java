import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * @author :xyx
 * @date :2021/2/2 18:08
 * @description:localdate localtime localdatetime类的使用,相比calendar类具有不可变性
 * @
 */
public class DateTimeTest5 {
    public static void main(String[] args) {
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDate);//2021-02-02
        System.out.println(localTime);//18:12:29.564
        System.out.println(localDateTime);//2021-02-02T18:12:29.564

        LocalDateTime localDateTime1 = LocalDateTime.of(2021, 2, 2, 12, 12, 12);
        System.out.println(localDateTime1);//2021-02-02T12:12:12

        System.out.println(localDateTime.getDayOfYear());//33
        System.out.println(localDateTime.getDayOfMonth());//2
        System.out.println(localDateTime.getDayOfWeek());//TUESDAY
        System.out.println(localDateTime.getMonth());//FEBRUARY
        System.out.println(localDateTime.getMonthValue());//2
        System.out.println(localDateTime.getMinute());//17

        //不可变性
        LocalDate localDate1 = localDate.withDayOfMonth(3);
        System.out.println(localDate);//2021-02-02
        System.out.println(localDate1);//2021-02-03
    }

}
