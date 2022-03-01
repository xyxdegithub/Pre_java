package demo;

import java.util.Arrays;
import java.util.Scanner;

public class MaoPao {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		int[] a;
		a=new int[5];
		System.out.println("请输入五个整数:");
		for(int i=0;i<a.length;i++){
			a[i]=scanner.nextInt();
		} 
	   System.out.print("你输入的五个整数是:");
       System.out.println(Arrays.toString(a));
       System.out.print("经过冒泡排序后:");
       MaoPao(a);
       System.out.println(Arrays.toString(a));
		int max=a[a.length-1];
		int min=a[0];
		System.out.println("输入的最大值是:"+max);
		System.out.println("输入的最小值是:"+min);
		

	}
	public static void MaoPao(int[] a){
		int temp;
		for(int i=0;i<a.length;i++){
			boolean flag=true;
			for(int j=0;j<a.length-1-i;j++){
				if(a[j]>a[j+1]){
					temp=a[j];
					a[j]=a[j+1];
					a[j+1]=temp;
					flag=false;
				}
			}
			if(flag){
				break;
			}
		}
	}

}
