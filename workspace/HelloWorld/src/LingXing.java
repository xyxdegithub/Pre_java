
public class LingXing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int i = 1; i < 4; i++) {
			for (int j = 1; j < 4 - i; j++) {
				System.out.print(" ");
			}
			for (int k = 0; k < 2 * i - 1; k++) {
				System.out.print("*");
			}
			System.out.println();
		}
		for (int i = 2; i >= 0; i--) {
			for (int j = 2; j > i; j--) {
				System.out.print(" ");
			}
			for (int k = 0; k < 2 * i + 1; k++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

}
