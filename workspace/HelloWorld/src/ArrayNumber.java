
public class ArrayNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
         int[] ArrayNumber;
         ArrayNumber=new int[10];
         for(int i=0;i<ArrayNumber.length;i++) {
        	 ArrayNumber[i]=(int) (100*Math.random());
        	System.out.print(ArrayNumber[i]+" ");
        	
         }
         System.out.println();
         int max=ArrayNumber[0];
         int min=ArrayNumber[0];
         int sum=0;
        
         for(int i=0;i<ArrayNumber.length;i++) {
        	 if(max<ArrayNumber[i]) {
        		 max=ArrayNumber[i];
        	 }else if(min>ArrayNumber[i]) {
        		 min=ArrayNumber[i];
        	 }
        	 sum+=ArrayNumber[i];
        	 
         }
         System.out.println("最大值是:"+max);
         System.out.println("最小值是:"+min);
         System.out.println("总和是:"+sum);
         System.out.print("平均值是:"+sum/10);
	}

}
