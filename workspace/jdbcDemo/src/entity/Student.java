package entity;
/**
 * 实体类（与数据库表相对应的类），主要有以下特征：
 * 1、类的属性与表的列名相对应
 * 2、类的属性均为私有属性，并提供get、set方法
 * 3、提供无参构造
 * 
 * java数据库访问对象操作数据库中表的数据时，通常要通过实体类进行中转。
 */
public class Student {
	private int id; //与数据库表student中id列相对应，下同
	private String name;
	private int age;
	
	/**
	 * 无参构造
	 */
	public Student(){
		
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}


	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", age=" + age + "]";
	}
	
	
	
	
}
