/**
 * 
 */
package collectiontest;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author xyx 2021年1月19日 上午8:45:50
 * 
 */
public class ArrayTest {
	public static void main(String[] args) {
		List<Integer> list1 = new ArrayList();
		list1.add(1);
		System.out.println(list1);// [1]
		list1.set(0, 2);
		System.out.println(list1);// [2]
		list1.add(2);
		// for循环遍历
		for (int i = 0; i < list1.size(); i++) {
			System.out.print(list1.get(i)+" ");
		}
		System.out.println("**************************");
		Iterator<Integer> it = list1.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}

			

	}
}
