import java.util.Scanner;

public class PangDuanZhiShu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print("请输入想查询在多少范围内的质数:");
		Scanner input = new Scanner(System.in);
		Boolean a = true;
		int n;
		n = input.nextInt();
		int i;
		int count = 0;

		for (i = 2; i <= n; i++) {
			for (int j = 2; j < i; j++) {
				if (i % j == 0) {
					a = false;
					break;
				} else {
					a = true;
				}
			}
			if (a) {
				System.out.print(i + " ");
				count++;

			}

		}

		System.out.println();
		System.out.println("共有" + count + "个质数");

	}

}
