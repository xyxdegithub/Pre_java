import java.util.Scanner;

public class Test {
	/*
	 * static int swap(int a, int b) { //交换两个int类型的值,并输出 int temp; temp = a; a = b;
	 * b = temp; System.out.println(a + " " + b); return 0; }
	 */

	public static void main(String[] args) {
		
		/*
		 * Scanner sc=new Scanner(System.in); System.out.print("请输入支付金额："); double
		 * amount=sc.nextDouble(); System.out.println();
		 * System.out.println("         支付成功"); System.out.println("         京东商城");
		 * System.out.println("    "+amount+"元");
		 * System.out.println("优惠金额            10.00元");
		 * System.out.println("支付方式            工商银行储蓄卡(5009)");
		 * System.out.println("交易时间            2018-11-27 00:34:02");
		 * System.out.println("订单编号             893412929");
		 */
        Scanner sc = new Scanner(System.in);
        int price = 2;
        System.out.println("      购票信息");
        System.out.println("-----------------");
        System.out.println("目的车站：人民广场");
        System.out.println("票价：2.00");
        System.out.print("购票数量：");
        int count = sc.nextInt();
        System.out.println("应付金额：" + count * price);
        System.out.print("已付金额：");
        int payment = sc.nextInt();
        System.out.println("找零：" + (payment - count * price));
		/*
		 * double b=0.1; System.out.println((int)b);
		 */
		/*
		 * char c=79; System.out.println(c); System.out.println((int)c);
		 */
		/*
		 * System.out.println("请输入两个整数:"); int a = new Scanner(System.in).nextInt(); int
		 * b = new Scanner(System.in).nextInt(); swap(a, b);
		 */
		
		/*
		 * int i1 = Integer.MAX_VALUE; int i2 = Integer.MIN_VALUE;
		 * System.out.println(i1); System.out.println(i2);
		 * 
		 * long a = Long.MAX_VALUE; long b = Long.MIN_VALUE; System.out.println(a);
		 * System.out.println(b);
		 * 
		 * byte b1 = Byte.MAX_VALUE; byte b2 = Byte.MIN_VALUE; System.out.println(b1);
		 * System.out.println(b2);
		 * 
		 * int xx = 365; byte b3 = (byte) xx; System.out.println(xx);
		 */
		
		/*
		 * int i = 0, j = 0; System.out.println(i++); // output 0 先取值再自增
		 * System.out.println(++j); // output 1 先自增再取值
		 */	}

}