package test;

public class PrimeNumberTest {

	public static void main(String[] args) {
		// 最小的质数是2,boolean true false运用
		int count = 0;
//		boolean flag = true;
		long start = System.currentTimeMillis();
		// System.out.print("1000000以内的质数有:");
		// Label:  continue
		for (int i = 2; i <= 1000000; i++) {
			boolean flag = true;
			// for (int j = 2; j < i; j++)
			for (int j = 2; j <= Math.sqrt(i); j++) { // 在这个范围内能被整除的就不是质数
				if (i % j == 0) {
					flag = false;
					break; // 优化
				}
			}
			if (flag == true) { // 没有进内层循环
				System.out.println(i);
				count++;
			}
//			flag = true;// 重置flag,在外循环一次后
		}
		long end = System.currentTimeMillis();
		System.out.println("所花费的时间" + (end - start) / 1000 + "秒");
		System.out.println("1000000以内的质数有" + count + "个");

	}

}
