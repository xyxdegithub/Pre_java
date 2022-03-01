package com.a;
/*
 * 父类Animal
 * 子类Dog
 * 测试类ExtendsTest
 */
 class  Animal{
	 public void move() {
		 System.out.println("我是动物,可以跑");
	 }
 }
 
 class Dog extends Animal{
	 public void move() {
		 super.move();
//		 父类中的move方法
		 System.out.println("我是动物中的狗,可以跑还会汪汪汪的叫!");
	 }
 }
 
 public class  ExtendsTest{
	 public static void main(String[] args) {
		Animal a=new Animal();
		Animal d=new Dog();
		a.move();
		d.move();
	}
 }
