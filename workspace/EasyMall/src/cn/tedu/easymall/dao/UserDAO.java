package cn.tedu.easymall.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import cn.tedu.easymall.entity.User;
import cn.tedu.easymall.util.DBUtil2;

public class UserDAO {
	
	// 私有的构造器
	private UserDAO(){}
	// 私有的静态的本类的唯一实例
	private static UserDAO instance=new UserDAO();
	// 公有的静态的返回本类唯一实例的方法
	public static UserDAO getInstance(){
		return instance;
	}
	
	
	public boolean insertUser(User user){
		String sql="insert into t_user values(null,?,?,?,?,?)";
		try(Connection conn=DBUtil2.getConn();
				PreparedStatement ps=conn.prepareStatement(sql)){
			// 绑定参数
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ps.setInt(3, user.getSalt());
			ps.setString(4, user.getEmail());
			ps.setString(5,user.getPhone());
			int row=ps.executeUpdate();
			if(row==1){
				return true;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}
	
	
	
	/**
	 * 使用用户名查询用户数据
	 * @param username 用户名
	 * @return 封装了用户数据的User对象
	 */
	public User getUserByUsername(String username){
		String sql="select * from t_user where username=?";
		try(Connection conn=DBUtil2.getConn();
				PreparedStatement ps=conn.prepareStatement(sql)){
			// 绑定参数
			ps.setString(1,username);
			ResultSet rs=ps.executeQuery(); // 执行查询
			if(rs.next()){
				int id=rs.getInt("id");
				String password=rs.getString("password");
				String email=rs.getString("email");
				String phone=rs.getString("phone");
				int salt=rs.getInt("salt");
				User user=new User(id, username, password, email, phone);
				user.setSalt(salt);
				return user;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}


	/**
	 * 更新用户密码
	 * @param user 封装用户信息的对象
	 * @return true-更新成功 false-更新失败
	 */
	public boolean updatePassword(User user) {
		String sql="update t_user set password=?, salt=? where username=?";
		
		try(Connection conn=DBUtil2.getConn();
				PreparedStatement ps=conn.prepareStatement(sql)){
			// 绑定参数
			ps.setString(1, user.getPassword());
			ps.setInt(2, user.getSalt());
			ps.setString(3, user.getUsername());
			// 执行更新
			int row=ps.executeUpdate();
			if(row==1){
				return true;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return false;
	}

}



