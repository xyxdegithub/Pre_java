package test;

import java.io.ObjectInputStream.GetField;

public class Test2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		{
			int x = 30;
			int[] a = new int[x];
			x = 60;
			System.out.println(a.length);// 30
		}

		{
			try {
				int a = 10;
				int b = 0;
				System.out.println(a / b);// java.lang.ArithmeticException: / by zero

			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("出现异常了,不要着急!");
				System.out.println(e.getMessage());/// by zero
				e.printStackTrace();// java.lang.ArithmeticException: / by zero
			}
		}
		
		
	}
}
