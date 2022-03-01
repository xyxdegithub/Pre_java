/**
 * 
 */
package extendstest;

/**
 * @author xyx 2021年1月12日 上午11:28:53
 */
public class Student extends Person {
	// 重写父类方法

	public void show() {
		//System.out.println("student的名字和年龄");
		System.out.println("super");
		super.show();
	}

}
