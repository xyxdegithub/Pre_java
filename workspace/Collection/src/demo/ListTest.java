package demo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class ListTest {
	public static void main(String[] args) {
		ArrayList<Integer> al = new ArrayList<Integer>();
		LinkedList<String> ll = new LinkedList<String>();
		al.add(1);
		al.add(2);
		al.remove(1);//刪除下标1的元素
		al.add(3);
		al.add(4);
		al.set(0,5);//将下标为0位的元素变成5；
		al.add(4);
		Iterator<Integer> it = al.iterator();// Iterator用于遍历al中的所有元素
		while (it.hasNext()) {
			System.out.print(it.next() + " ");
		}
		ll.add("I");
		ll.add("LOVE");
		ll.add("PROGRAMING");
		Iterator<String> it2 = ll.iterator();// Iterator用于遍历ll中的所有元素
		while (it2.hasNext()) {
			System.out.print(it2.next() + " ");
		}

	}

}
