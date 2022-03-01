import java.util.Scanner;

public class LeapYear {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.println("请输入一个年份:");
		int year;
		year = input.nextInt();
		if (year < 0) {
			System.out.println("输入有误,退出程序!");
			System.exit(0);
		} else if ((year % 4 == 0) && (year % 100 != 0)) {
			System.out.println(year + "年" + "是闰年");
		} else if ((year % 400 == 0)) {
			System.out.println(year + "年" + "是闰年");
		} else {
			System.out.println(year + "年" + "不是闰年");
		}

	}

}
