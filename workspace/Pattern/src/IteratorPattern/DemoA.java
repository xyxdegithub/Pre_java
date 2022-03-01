package IteratorPattern;

import java.util.ArrayList;

import java.util.List;

public class DemoA {

	public static void main(String[] args) {
		Aggregate ag = new ConcreteAggregate();
		ag.add("北京大学");
		ag.add("清华大学");
		ag.add("浙江大学");
		ag.add("华中科技大学");
		ag.add("中国科学技术大学");
		System.out.print("List里有:");
		Iterator it = ag.getIterator();
		while (it.hasNext()) {

			System.out.print(it.next().toString() + " ");

		}
		System.out.println();
		System.out.println("First是" + it.first());

	}
}

// 抽象聚合
interface Aggregate {
	public void add(Object obj);// 添加对象

	public void remove(Object obj);// 删除对象

	public Iterator getIterator();

}

// 具体聚合
class ConcreteAggregate implements Aggregate {
	private List<Object> list = new ArrayList<Object>();

	@Override
	public void add(Object obj) {
		list.add(obj);

	}

	@Override
	public void remove(Object obj) {
		list.remove(obj);

	}

	@Override
	public Iterator getIterator() {

		return (new ConcreteIterator(list));
	}

}

// 抽象迭代器
interface Iterator {
	public Object first();

	public Object next();

	public boolean hasNext();
}

// 具体迭代器
class ConcreteIterator implements Iterator {
	private List<Object> list = null;
	private int index = -1;

	public ConcreteIterator(List<Object> list) {
		this.list = list;

	}

	public Object first() {
		index = 0;
		Object obj = list.get(index);
		return obj;
	}

	public Object next() {
		Object obj = null;
		if (hasNext()) {
			obj = list.get(++index);
		}
		return obj;
	}

	public boolean hasNext() {
		if (index < list.size() - 1) {
			return true;
		} else {
			return false;
		}
	}
}
