package oop;

import java.lang.reflect.Array;
import java.util.Arrays;

public class StudentTest {

	public static void main(String[] args) {
		Student[] s = new Student[8];
//		对信息赋值并遍历所有学生信息
		System.out.println("*****" + "学生信息" + "*****");
		for (int i = 0; i < s.length; i++) {
			s[i] = new Student();
			s[i].number = i + 1;
			s[i].score = (int) (Math.random() * 100 + 1);
			s[i].state = (int) (Math.random() * 6 + 1);
			System.out.println(s[i].toString());
		}
//		查找年级为3的学生信息
		System.out.println("********************");
		for (int i = 0; i < s.length; i++) {
			if (s[i].state == 3) {
				System.out.println("年级为3的信息:" + s[i].toString());
			}
		}
//		对成绩进行冒泡排序
		System.out.println("********************");
		for (int i = 0; i < s.length - 1; i++) {
			for (int j = 0; j < s.length - i - 1; j++) {
				if (s[j].score < s[j + 1].score) {
					Student temp = s[j + 1];
					s[j + 1] = s[j];
					s[j] = temp;
				}
			}
		}
		// 排序后的成绩
		System.out.println("成绩排序后:");
		for (int i = 0; i < s.length; i++) {
			System.out.println(s[i].toString());
		}
	}
}

class Student {
	int number; // 学号
	int state;// 年级
	int score;// 分数

	@Override
	public String toString() {
		return "Student [number=" + number + ", state=" + state + ", score=" + score + "]";
	}

	public String info() {
		return "学号:" + number + "   " + "年级:" + state + "   " + "成绩:" + score + "   ";
	}
}
