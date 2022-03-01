package test;

public class ArrayTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = new int[] { 8, 9, 0, 3, 6, 5, 8 };
		int[] index = new int[] { 0, 2, 2, 3, 4, 6, 1, 5, 5, 2, 5 };
		String tel = "";
		for (int i = 0; i < index.length; i++) {
			tel += a[index[i]];
		}
		System.out.println(tel);
	}

}
