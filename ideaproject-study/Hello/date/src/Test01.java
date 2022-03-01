import java.util.Calendar;
import java.util.Scanner;

/**
 * @author :xyx
 * @date :2021/5/22 10:16
 * @description:计算某一天是这年的第几周
 * @
 */
public class Test01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer year = null;
        Integer month = null;
        Integer day = null;
        System.out.println("请输入年份:");
        year = scanner.nextInt();
        System.out.println("请输入月份:");
        month = scanner.nextInt();
        System.out.println("请输入日份:");
        day = scanner.nextInt();
        //得到实例化对象
        Calendar calendar = Calendar.getInstance();
        //设置为2021年
        calendar.set(Calendar.YEAR, year);
        //4代表五月
        calendar.set(Calendar.MONTH, month - 1);
        calendar.set(Calendar.DAY_OF_MONTH, day);
        int week = calendar.get(Calendar.WEEK_OF_YEAR);
        System.out.println(year + "年" + month + "月" + day + "日" + "是今年的第" + week + "周");
    }

}
