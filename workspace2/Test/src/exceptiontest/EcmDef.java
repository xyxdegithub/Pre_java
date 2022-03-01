/**
 * 
 */
package exceptiontest;

/**
 * @author xyx 2021年1月18日 下午5:14:34
 * 
 *         (1)在主类(EcmDef)中定义异常方法(ecm)完成两数相除功能。 (2)在main()方法中使用异常处理语句进行异常处理。
 * 
 */
public class EcmDef {
	public static int ecm(int i, int j) throws EcDef {
		if (i < 0 || j < 0) {
			// System.out.println("分子或分母为负数!");
			// 手动生成一个异常对象
			throw new EcDef("分子或分母为负数!");
		}
		int result = i / j;
		return result;
	}

	public static void main(String[] args) {

		try {
			int i = Integer.parseInt(args[0]);
			int j = Integer.parseInt(args[1]);
			System.out.println(ecm(i, j));
		} catch (NumberFormatException e) {
			System.out.println("对 数 据 类 型 不 一 致!");
		} catch (EcDef e) {
			System.out.println(e.getMessage());
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("缺 少 命 令 行 参 数!");
		} catch (ArithmeticException e) {
			System.out.println("除0!");
		}
	}

}
