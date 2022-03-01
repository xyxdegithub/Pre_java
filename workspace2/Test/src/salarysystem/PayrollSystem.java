/**
 * 
 */
package salarysystem;

import java.util.Scanner;

/**
 * @author xyx 2021年1月15日 下午4:27:33
 *         定义PayrollSystem类，创建Employee变量数组并初始化，该数组存放各类雇员对象的引用。
 *         利用循环结构遍历数组元素，输出各个对象的类型,name,number,birthday,以及该对象生日。
 *         当键盘输入本月月份值时，如果本月是某个Employee对象的生日，还要输出增加工资信息。
 *         多态
 */
public class PayrollSystem {
	public static void main(String[] args) {
		Employee[] e = new Employee[2];
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入当前月份:");
		int month = sc.nextInt();
		e[0] = new SalariedEmployee("苏大强", 1001, new MyDate(1997, 7, 1), 10000.5);
		e[1] = new HourlyEmployee("冯森", 1002, new MyDate(1989, 5, 29), 110.110, 300);
		for (int i = 0; i < e.length; i++) {
			System.out.println(e[i]);

			if (month == e[i].getBirthday().getMonth()) {
				System.out.println(e[i].getName() + "的生日工资奖励100元!" + "奖励后的总工资为:" + e[i].earnings()+100);
			}
		}
	}
}
