package SimpleFactoryPattern;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = null;
		Scanner input=new Scanner(System.in);
		
		System.out.print("请输入你想生产的电视品牌:");
		s=input.nextLine();
            try {
				TV  tv=TVFactory.creteTV(s);
				tv.play();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            
            
	}

}
