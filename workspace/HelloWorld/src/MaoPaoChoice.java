import java.util.Scanner;

public class MaoPaoChoice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int in[] = new int[10];
		for (int i = 0; i < in.length; i++) {

			System.out.print("请输入" + (i + 1) + "个整数:");
			in[i] = input.nextInt();
		}
		// 排序
		for (int i = 0; i < in.length - 1; i++) {
			for (int j = in.length - 1; j > i; j--) {
				if (in[j] < in[j - 1]) {
					int t;
					t = in[j - 1];
					in[j - 1] = in[j];
					in[j] = t;
				}
			}
		}
		for (int i = 0; i < in.length; i++) {
			if (i < in.length - 1) {
				System.out.print(in[i] + "<");
			} else {
				System.out.print(in[i]);
			}

		}

	}
}
