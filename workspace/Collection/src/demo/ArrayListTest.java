package demo;

import java.util.ArrayList;
import java.util.List;

class Product {

	private int id;
	private String name;
	private String price;

	public Product(int id, String name, String price) {

		this.id = id;
		this.name = name;
		this.price = price;
	}

	public String toString() {
		
		return " [商品编号=" + id + ", 名称=" + name + ", 价格=" + price + "]";
	}

}

public class ArrayListTest {
	public static void main(String[] args) {
		List<Product> al = new ArrayList<Product>();
		Product p1 = new Product(1, "康师傅方便面", "2.5元");
		Product p2 = new Product(2, "农夫山泉", "2元");
		Product p3 = new Product(3, "双汇火腿肠", "2元");
		Product p4 = new Product(4, "面包", "5元");
		al.add(p1);
		al.add(p2);
		al.add(p3);
		al.add(p4);
		for (int i = 0; i < al.size(); i++) {// 用for循环遍历输出
			System.out.println(al.get(i));

		}
	}
}
