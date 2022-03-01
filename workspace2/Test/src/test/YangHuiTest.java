package test;

public class YangHuiTest {

	public static void main(String[] args) {
//		用二维数组实现十行杨辉三角
//		动态初始化
		int[][] yangHui = new int[10][];
//		数组中的数组,初始化
		for (int i = 0; i < yangHui.length; i++) {
			yangHui[i] = new int[i + 1];

//		赋值
//		for (int i = 0; i < yangHui.length; i++) { //重复代码，改一下
			yangHui[i][0] = 1;
			yangHui[i][yangHui[i].length - 1] = 1;
			for (int j = 1; j < yangHui[i].length - 1; j++) {
				yangHui[i][j] = yangHui[i - 1][j - 1] + yangHui[i - 1][j];
			}
		}

//		遍历输出
		for (int i = 0; i < yangHui.length; i++) {
			for (int j = 0; j < yangHui[i].length; j++) {
				System.out.print(yangHui[i][j] + " ");
			}
			System.out.println();
		}

	}
}
