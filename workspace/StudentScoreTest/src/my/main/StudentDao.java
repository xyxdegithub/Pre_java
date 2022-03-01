package my.main;

import java.util.ArrayList;
import java.util.Scanner;

   public class StudentDao {
	   
	   static ArrayList<Student> list=new ArrayList<Student>();
	   //显示所有学生所有信息
      public static ArrayList<Student> showAll(){
    	  
    	  Student s=new Student();
    	  int id=s.getId();
    	  String name=s.getName();
    	  String age=s.getAge();
    	  int chinese=s.getChinese();
    	  int math=s.getMath();
    	  int english=s.getEnglish();
    	  int comprehensiveScienceTest=s.getComprehensiveScienceTest();
    	  list.add(s);
		  return list;
		 
      }
     public void getShowAll() {
    	 showAll();
    	 for(int i=0;i<list.size();i++) {
    		 System.out.println(list.get(i));
    	 }
     }
      //增加学生信息
      public static boolean insert(){
    	  Student s=new Student();
    	  Scanner input=new Scanner(System.in);
    	  boolean flag=true;
    	  if(flag){
    	  System.out.println("请输入学生学号:");
    	  int id=input.nextInt();
    	  s.setId(id);
    	  System.out.println("请输入学生姓名:");
    	  String name=input.nextLine();
    	  s.setName(name);
    	  System.out.println("请输入学生年龄:");
    	  String age=input.nextLine();
    	  s.setAge(age);
    	  System.out.println("请输入学生语文成绩:");
    	  int chinese =input.nextInt();
    	  s.setChinese(chinese);
    	  System.out.println("请输入学生数学成绩:");
    	  int math=input.nextInt();
    	  s.setMath(math);
    	  System.out.println("请输入学生英语成绩:");
    	  int english=input.nextInt();
    	  s.setEnglish(english);
    	  System.out.println("请输入学生理综成绩:");
    	  int comprehensiveScienceTest=input.nextInt();
    	  s.setComprehensiveScienceTest(comprehensiveScienceTest);
    	  System.out.println("增加学生信息成功!");
    	  return true;
    	  }else{
    		  return false;
    	  } 	  
      }
      
      
      }
