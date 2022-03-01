package default2;

public class Parallelogram {

	public static void main(String[] args) {
//整体来看,由内到外,一层一层
		for(int i=1;i<=5;i++) {
		for(int j=1;j<=5-i;j++) {
			System.out.print(" ");
		}
		
		for(int k=1;k<=5;k++) {
			System.out.print("·");

		}
		System.out.println();

	}
	}

}
