import java.util.Date;

/**
 * @author :xyx
 * @date :2021/1/21 11:45
 * @description:常用类测试
 * @
 */
public class DateTimeTest {
    public static void main(String[] args) {
        {
            System.out.println("****************system****************");
            long time = System.currentTimeMillis();
            System.out.println(time);//1970年一月一日到现在的毫秒时间差
        }
        {
            System.out.println("****************date****************");
            Date date = new Date();
            System.out.println(date.toString());//Thu Jan 21 11:53:32 CST 2021
            System.out.println(date.getTime());//毫秒数
            Date date1 = new Date(1111111111994L);
            System.out.println(date1.toString());//Fri Mar 18 09:58:31 CST 2005
        }
    }

}
