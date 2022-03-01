import java.util.Scanner;

public class ArrayOfTwo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input=new Scanner(System.in);
        float sorce[][]=new float[3][2];
        for(int i=0;i<3;i++) {//输入成绩
        	System.out.println("            请输入第"+(i+1)+"个学生的成绩");
        	for(int j=0;j<2;j++) {
        		if(j==0) {
        		System.out.print("语文成绩是:");
        	}else {
        		System.out.print("数学成绩是:");
        	}
        		sorce[i][j]=input.nextFloat();
        }       	
	}
//求每一门总成绩
        float ywtotal=0;
        float sxtotal=0;
        for(int i=0;i<sorce.length;i++) {
        	ywtotal+=sorce[i][0];
        	sxtotal+=sorce[i][1];
        }
        System.out.println("语文总成绩是:"+ywtotal);
        System.out.println("数学总成绩是:"+sxtotal);
	
	//对语文成绩进行排序
       float yuwen[]=new float[3];
       for(int i=0;i<yuwen.length;i++) {
    	   yuwen[i]=sorce[i][0];
       }
	for(int i=0;i<yuwen.length-1;i++) {
		float temp;
		for(int j=yuwen.length-1;i<j;j--) {
			if(yuwen[j]<yuwen[j-1]) {
			temp=yuwen[j-1];
			yuwen[j-1]=yuwen[j];
			yuwen[j]=temp;
		}
			
	}
		
}
	for(int i=0;i<yuwen.length;i++) {
		System.out.println(yuwen[i]);
	}
}
}