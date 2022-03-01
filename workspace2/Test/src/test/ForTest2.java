package test;

public class ForTest2 {

	public static void Shui() {
		int count = 0;
		for (int i = 100; i < 1000; i++) {
			int a = i / 100; // 百位数
			int b = i % 100 / 10; // 十位数
			int c = i % 10; // 个位数
			if (i == (a * a * a + b * b * b + c * c * c)) {
				System.out.print(i + ";");
				count++;
			}
		}
		System.out.println();
		System.out.println("一共有" + count + "个水仙花数!");
	}

	public static void Wan() {
		// 求完数
		int count = 0;
		for (int i = 1; i < 1000; i++) {
			int sum = 0;
			for (int j = 1; j < i; j++) {
				if (i % j == 0) {
					sum = sum + j;
				}
			}
			if (sum == i) {
				System.out.print(i + ";");
				count++;
			}
		}
		System.out.println();
		System.out.println("1000以内一共有" + count + "个完数!");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 求水仙花数
		Shui();
		Wan();
	}

}
