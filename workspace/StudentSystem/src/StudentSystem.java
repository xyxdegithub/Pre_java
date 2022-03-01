import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;


public class StudentSystem implements StudentInterface{
	Scanner scanner=new Scanner(System.in);
	public void shouWelcome(){
		System.out.println("************欢迎来到学生管理系统************");
		System.out.println("************系统初始化成功************");
	}
	
	public void exit(){
		System.out.println("************谢谢使用学生管理系统************");
	}
//	显示系统菜单
	public void showMenu(){
		System.out.println();
		System.out.println("1-->显示所有学生信息");
		System.out.println("2-->添加学生信息");
		System.out.println("3-->根据学号查学生");
		System.out.println("4-->根据名字查学生");
		System.out.println("5-->根据学号删除学生");
		System.out.println("6-->根据学号修改");
		System.out.println("7-->退出");
		
		
	}
    
	private Map<Integer,Student> students=new HashMap<>();
	
	public void showAll() {
		Set<Integer> ids=students.keySet();
        Iterator<Integer> iterator=ids.iterator();	
        while(iterator.hasNext()){
        	Integer id=iterator.next();
        	Student student=students.get(id);
        	System.out.println(student);
        }
	}

	@Override
	public boolean addStudent() {
//		System.out.println("输入学生学号,要求是整数:");
//		int id=s.nextInt();
		int id=MyUtil.getInputNumber("输入学生学号,要求是整数:", scanner);
		String name=MyUtil.getInputString("输入学生姓名:", scanner);
		int age=MyUtil.getInputNumber("输入学生年龄,要求是整数:", scanner);
		Gender gender=MyUtil.getInputString("请输入学生的性别:", scanner).equals("男")?Gender.男:Gender.女;
		
		Student s=new Student(id,name,age,gender);
		students.put(id, s);
		System.out.println("添加成功");
        return  true;
	}

	@Override
	public Student findStudentById(int id) {
		Student student=students.get(id);
		if(student!=null){
			System.out.println(student);
		}else{
			System.out.println("该学生不存在!");
		}
		return student;
	}
	
	public Student findStudentById(){
		int id=MyUtil.getInputNumber("请输入要查找的学生的学号:", scanner);
		return findStudentById(id);
	}

	
	public List<Student> findStudentByName(String name) {
//		便利所有学生，然后每个对照和name
		List<Student> list=new ArrayList<>();
		Collection<Student> stus=students.values();
		Iterator<Student> iterator=stus.iterator();
		while(iterator.hasNext()){
			Student student=iterator.next();
			if(student.getName().equals(name)){
				list.add(student);
			}
		}
		return list.size()==0?null:list;
	}
	
	public void findStudentByName(){
		String name=MyUtil.getInputString("请输入要查找的学生的姓名:", scanner);
		List<Student> stus=findStudentByName(name);
		if(stus==null){ 
			System.out.println("该姓名的学生不存在！");
		}else{
			System.out.println("查找到的学生信息如下");
			for(int i=0;i<stus.size();i++){
				System.out.println(stus.get(i));
			}
		}
		
	}

	
	public boolean removeStudentById(int id) {
		Student student=students.remove(id);
		return student==null?false:true;
	}

public void  removeStudentById() {
		int id=MyUtil.getInputNumber("请输入要删除学生的学号:", scanner);
		 boolean bool=removeStudentById(id);
		 if(true){
			 System.out.println("删除学生成功!");
		 }else{
			 System.out.println("删除学生失败,该学生不存在!");
		 }
	}

	

	
	public boolean modifyStudentById(int id) {
		Student student=students.get(id);
		if(student!=null){
			id=MyUtil.getInputNumber("输入学生学号,要求是整数:", scanner);
			String name=MyUtil.getInputString("输入学生姓名:", scanner);
			int age=MyUtil.getInputNumber("输入学生年龄,要求是整数:", scanner);
			Gender gender=MyUtil.getInputString("请输入学生的性别:", scanner).equals("男")?Gender.男:Gender.女;
			student.setAge(age);
			student.setName(name);
			student.setGender(gender);
			student.setId(id);
		}
		
		return student==null?false:true;
	}
	
public void  modifyStudentById() {
		int id=MyUtil.getInputNumber("请输入你要修改的学生学号:", scanner);
		boolean bool=modifyStudentById(id);
		if(bool){
			System.out.println("修改学生信息成功!");
		}else{
			System.out.println("学生不存在!");
		}
		
	}
}
