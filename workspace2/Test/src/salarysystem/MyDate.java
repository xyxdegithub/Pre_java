/**
 * 
 */
package salarysystem;

/**
 * @author xyx 2021年1月15日 下午4:14:37 MyDate类包含:private成员变量year,month,day ；
 *         toDateString()方法返回日期对应的字符串：xxxx年xx月xx日
 */
public class MyDate {
	private int year;
	private int month;
	private int day;

	public MyDate(int year, int month, int day) {
		super();
		this.year = year;
		this.month = month;
		this.day = day;
	}

	public int getYear() {
		return year;
	}

	public int getMonth() {
		return month;
	}

	public int getDay() {
		return day;
	}

	public String toDateString() {
		return year + "年" + month + "月" + day + "日";
	}
}
