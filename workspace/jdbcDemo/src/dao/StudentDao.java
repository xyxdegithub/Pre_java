package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import util.DBUtil;
import entity.Student;

/**
 * DAO:(Data Acesss Object)，即数据访问对象，即该类的对象是用于对数据库的相应表进行各种
 * 访问操作（增、删、改、查）的对象。
 */
public class StudentDao {
	/**
	 * 插入数据方法
	 * @param s
	 */
	public void insert(Student s){
		Connection conn=DBUtil.getConnection();
		String sql="insert into student values(?,?,?)";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, s.getId());
			ps.setString(2, s.getName());
			ps.setInt(3, s.getAge());
			ps.executeUpdate();
			DBUtil.close(conn);
			System.out.println("插入成功！");
		} catch (SQLException e) {
			System.out.println("插入学生记录失败");
			e.printStackTrace();
		}
	}
	
	/**
	 * 按id值进行查询
	 * @param id
	 * @return 返回一个Student类的对象
	 */
	public Student findById(int id){
		Student s=null;
		Connection conn=DBUtil.getConnection();
		try {
			String sql="select * from student where id=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){ 						//   1001	张三	18
				String name=rs.getString("name");
				int age=rs.getInt("age");
				s=new Student();
				s.setId(id);
				s.setName(name);
				s.setAge(age);
			}
			DBUtil.close(conn);
		} catch (SQLException e) {
			System.out.println("按id查询失败");
			e.printStackTrace();
		}
		
		return s;
	}
	
	/**
	 * 查询表的所有记录
	 * @return 返回一个Studnet列表
	 */
	public ArrayList<Student> findAll(){
		ArrayList<Student> studList=new ArrayList<Student>();
		Connection conn=DBUtil.getConnection();
		try {
			String sql="select * from student";
			PreparedStatement ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				int id=rs.getInt("id");
				String name=rs.getString("name");
				int age=rs.getInt("age");
				Student s=new Student();
				s.setId(id);
				s.setName(name);
				s.setAge(age);
				studList.add(s);
			}
			DBUtil.close(conn);
		} catch (SQLException e) {
			System.out.println("查询学生表所有记录失败！");
			e.printStackTrace();
		}
		
		return studList;
	}
	
	/**
	 * 按id更新学生记录
	 * @param s Student对象
	 */
	public void updateById(Student s){
		Connection conn=DBUtil.getConnection();
		try {
			String sql="update student set name=?,age=? where id=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1,s.getName());
			ps.setInt(2, s.getAge());
			ps.setInt(3, s.getId());
			ps.executeUpdate();
			DBUtil.close(conn);
			System.out.println("按id更新学生记录成功");
		} catch (SQLException e) {
			System.out.println("按id根据学生信息失败");
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		StudentDao dao=new StudentDao();
		Student s=dao.findById(1001);
		//s.setAge(s.getAge()+1);
		s.setName("张三丰");
		dao.updateById(s);
		
/*		//假设从前端页面（网页）获取到了用户提交的数据
		int id=7777;
		String name="小龙女";
		int age=30;
		//封装成一个Student对象
		Student s=new Student();
		s.setId(id);
		s.setName(name);
		s.setAge(age);
		//调用dao对象，将该Student对象写入数据库表
		dao.insert(s);*/
		
		//Student s2=dao.findById(1001);
		//System.out.println(s2);
		
//		ArrayList<Student> userList=dao.findAll();
//		 for (Student student : userList) {
//			System.out.println(student);
//		}
		
		
	}
	
}
