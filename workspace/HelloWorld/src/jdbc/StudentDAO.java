package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class StudentDAO {
	
	// 显示数据库所有信息
	public static ArrayList<User> showAll() {
		Connection conn;
		try {
			ArrayList<User> list = new ArrayList<User>();
			conn = DBUtils.getConnection();
			String sql = "select * from t_students";

			PreparedStatement ps = conn.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();
			// 操作ResultSet结果集
			while (rs.next()) {
				User u = new User();
				// 通过列名获取指定字段的值
				u.setId(rs.getInt("id"));
				u.setName(rs.getString("name"));
				u.setPassword(rs.getString("password"));
				u.setEmail(rs.getString("email"));
				u.setBirthday(rs.getString("birthday"));
				list.add(u);
			}
			for (int i = 0; i < list.size(); i++) {
				System.out.println(list.get(i));
			}
			DBUtils.release(ps, conn, rs);
			return list;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Statement stat = conn.createStatement();
		// ResultSet rs = stat.executeQuery(sql);
		return null;
	}

	// 插入数据
	public static boolean insert(User u) {
		try {
			Connection conn = DBUtils.getConnection();
			String sql = "insert into t_students values " + "(null,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, u.getName());
			ps.setString(2, u.getPassword());
			ps.setString(3, u.getEmail());
			ps.setString(4, u.getBirthday());
			boolean flag;
			if (flag = true) {
				ps.executeUpdate();
				System.out.println("插入数据成功");
			}
			return true;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;

	}
	// 按id查找信息
	public static User findById(int id) {
		User u = new User();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			// 获得数据的连接
			conn = DBUtils.getConnection();
			// 发送SQL语句
			String sql = "SELECT * FROM t_students WHERE id=" + id;
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			// 处理结果集
			while (rs.next()) {

				u.setId(rs.getInt("id"));
				u.setName(rs.getString("name"));
				u.setPassword(rs.getString("password"));
				u.setEmail(rs.getString("email"));
				u.setBirthday(rs.getString("birthday"));
				return u;
			}
			
			DBUtils.release(ps, conn, rs);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	//删除数据
	public static boolean delete(int id) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs=null;
		try {
			conn=DBUtils.getConnection();
			String sql="delete from t_students where id ="+id;
			ps=conn.prepareStatement(sql);
			int row=ps.executeUpdate();
			if(row>=1) {
				System.out.println("删除成功!");
				return true;
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	
}
