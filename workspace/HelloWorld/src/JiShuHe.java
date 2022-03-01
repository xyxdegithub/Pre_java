
public class JiShuHe {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int count=0;
		int sum=0;
       for(int number=1;number<100;number+=2) {
    	   sum+=number;
    	   
    	   count++;
    	   System.out.println("第"+count+"次和是"+sum);
       }
       System.out.println("奇数总和是"+sum);
	}

}
