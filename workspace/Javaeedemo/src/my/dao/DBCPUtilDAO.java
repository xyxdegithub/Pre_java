package my.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import my.entity.User;
import my.util.DBCPUtil;

public class DBCPUtilDAO {
	// 插入数据
	public static boolean insert(User u) throws SQLException {
		Connection conn = DBCPUtil.getConnection();

		String sql = "insert into user2 (id,name,age) values (?,?,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, u.getId());
			ps.setString(2, u.getName());
			ps.setString(3, u.getAge());
			int row = ps.executeUpdate();
			if (row >= 1) {
				System.out.println("往数据库插入数据成功!");
				DBCPUtil.closeConn(conn);
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	// 显示所有数据
	public static ArrayList<User> showAll() throws SQLException {
		Connection conn = DBCPUtil.getConnection();
		ArrayList<User> list = new ArrayList<User>();
		String sql = "select * from user2";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				User u = new User();
				u.setId(rs.getString("id"));
				u.setName(rs.getString("name"));
				u.setAge(rs.getString("age"));
				list.add(u);
			}
			System.out.println("查找数据库所有数据成功");
			DBCPUtil.closeConn(conn);
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

}
