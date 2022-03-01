package my.main;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
	public void mainMenu() {

		System.out.println("**** 欢 " + "迎 " + "到 " + "学 " + "生 " + "成 " + "绩 " + "管 " + "理 " + "系 " + "统 ****");
		System.out.println("1:" + "查看所有学生所有信息");
		System.out.println("2:" + "添加学生信息");
		System.out.println("3:" + "删除信息");
		System.out.println("4:" + "按学号查找学生");
		System.out.println("5:" + "查找学生总分");
		System.out.println("6:" + "查找学生平均分");
		System.out.println("7:" + "退出系统");
		System.out.println("****************************************");
		System.out.println("***请输入你的选项***");

	}

	public static void first() {
		StudentDao dao = new StudentDao();
		Menu menu = new Menu();
		menu.mainMenu();
		Scanner input = new Scanner(System.in);
		int num = input.nextInt();
	}

}
