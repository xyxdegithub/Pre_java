
public class ShuiXianHuaShu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        System.out.println("以下是所有水仙花数");
        int number=100;
        int i,j,k;
        for(int sum;number<1000;number++) {
        	i=number/100;
        	j=(number-i*100)/10;
        	k=number-i*100-j*10;
        	sum=i*i*i+j*j*j+k*k*k;
        	if(sum==number) {
        		System.out.println(number+"是一个水仙花数");
        	}
        }
	}

}
