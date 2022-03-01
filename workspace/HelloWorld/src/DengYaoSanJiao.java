
public class DengYaoSanJiao {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int j = 1; j < 6; j++) {    //循环6次
			for (int k = 1; k < 6 - j; k++) {
				System.out.print(" ");
			}
			for (int i = 0; i < 2 * j - 1; i++) {
				System.out.print("*");
			}
			System.out.println();
		}

	}
}
