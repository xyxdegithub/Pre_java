import java.util.Scanner;


public class Test {
/*使用合适的容器实现学生管理系统
 * 学生属性:学号,名字,年龄,性别
 * 实现所有功能
 * 遍历所有学生信息
 * 添加学生信息
 * 根据学号查
 * 根据名字查
 * 根据学号删除学生
 * 根据学号修改
 
 */
	public static void main(String[] args) {
		StudentSystem ss=new StudentSystem();
		
        ss.shouWelcome();
    
       Scanner scanner=new Scanner(System.in);
       
       while(true){
    	   ss.showMenu();
    	  int input= MyUtil.getInputNumber("请选择你的操作(1~7)", scanner);
    	  switch(input){
    	  case 1:
    		 ss.showAll();
    		 break;
    	  case 2:
    		  ss.addStudent();
    		  break;
    	  case 3:
    		  ss.findStudentById();
    		  break;
    	  case 4:
    		  ss.findStudentByName();
    		  break;
    	  case 5:
    		  ss.removeStudentById();
    		  break;
    	  case 6:
    		  ss.modifyStudentById();
    		  break;
    	  case 7:
    		  ss.exit();
    		  return ;
    	  }
    	  
    	  
       }
	}

}
