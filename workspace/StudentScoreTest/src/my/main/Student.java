package my.main;

public class Student {
       private Integer id;  //学生学号唯一
       private String  name; //
       private String  age;
       private Integer  chinese;
       private Integer  math;
       private Integer  english;
       private Integer comprehensiveScienceTest;
	public Student() {
	
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public Integer getChinese() {
		return chinese;
	}
	public void setChinese(Integer chinese) {
		this.chinese = chinese;
	}
	public Integer getMath() {
		return math;
	}
	public void setMath(Integer math) {
		this.math = math;
	}
	public Integer getEnglish() {
		return english;
	}
	public void setEnglish(Integer english) {
		this.english = english;
	}
	public Integer getComprehensiveScienceTest() {
		return comprehensiveScienceTest;
	}
	public void setComprehensiveScienceTest(Integer comprehensiveScienceTest) {
		this.comprehensiveScienceTest = comprehensiveScienceTest;
	}
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", age=" + age
				+ ", chinese=" + chinese + ", math=" + math + ", english="
				+ english + ", comprehensiveScienceTest="
				+ comprehensiveScienceTest + "]";
	}
	
	
       
}
