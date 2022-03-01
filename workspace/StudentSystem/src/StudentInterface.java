import java.util.List;

/*添加学生信息
 * 遍历所有学生信息
 * 添加学生信息
 * 根据学号查
 * 根据名字查
 * 根据学号删除学生
       根据学号修改*/
public interface StudentInterface {
      void showAll();
// 遍历所有学生信息     
      boolean addStudent();
//  添加学生信息    添加成功返回true
      Student findStudentById(int id);
//  根据学号查    
      List<Student> findStudentByName(String name);
//  根据名字查    
      boolean removeStudentById(int id);
//  根据学号删除学生    
      boolean modifyStudentById(int id);
//   根据学号修改   
}
