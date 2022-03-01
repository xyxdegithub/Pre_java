import java.util.Calendar;

/**
 * @author :xyx
 * @date :2021/2/2 15:04
 * @description:calendar日历类的使用,是一个抽象类
 * @
 */
public class CalendarTest {
    public static void main(String[] args) {
        //实例化
        Calendar instance = Calendar.getInstance();
        System.out.println(instance.getClass());//class java.util.GregorianCalendar
        //常用方法 get,set,add,gettime(calendar到date),settime(date到calendar)
        System.out.println(instance.get(Calendar.DAY_OF_MONTH));//获取是这个月第几天
        System.out.println(instance.get(Calendar.DAY_OF_WEEK));
        System.out.println(instance.get(Calendar.DAY_OF_YEAR));

        instance.set(Calendar.DAY_OF_MONTH, 3);//改
        System.out.println(instance.get(Calendar.DAY_OF_MONTH));//3
    }

}
