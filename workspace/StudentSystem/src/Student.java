
public class Student {
//学生属性:学号，名字，年龄，性别
	
	private int id;
	private String name;
	private int age;
	private Gender gender;
	
	public Student() {
		
	}

	public Student(int id, String naem, int age, Gender gender) {
		
		this.id = id;
		this.name = naem;
		this.age = age;
		this.gender = gender;
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

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "Student [学号=" + id + ", 姓名=" + name + ", 年龄=" + age
				+ ", 性别=" + gender + "]";
	}
	
	

}
enum Gender{
	男,女
}
