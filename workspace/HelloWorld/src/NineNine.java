
public class NineNine {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
    System.out.print("                                                      九九乘法表                         ");
    for(int i=0;i<10;i++) {
    	for(int j=1;j<=i;j++) {
    		System.out.print(" "+j+"x"+i+"="+i*j);
    	}
    	System.out.println();
    }
	}
}
