import java.util.Scanner;

public class DengJi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.println("��������ķ���:");
		int grade;
		grade = input.nextInt();
		if (grade < 60) {
			System.out.println("D");
		} else if (grade >= 60 && grade < 80) {
			System.out.println("C");
		} else if (grade >= 80 && grade < 90) {
			System.out.println("B");
		} else if (grade >= 90) {
			System.out.println("A");
		}
	}

}
