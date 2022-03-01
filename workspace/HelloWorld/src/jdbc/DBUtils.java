package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtils {
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		// 注册数据库驱动
		Class.forName("com.mysql.jdbc.Driver");
		// 通过DriverManager获取数据库连接
		String url = "jdbc:mysql://localhost:3306/jdbc?characterEncoding=utf8";
		String username = "root";
		String password = "123456";
		Connection conn = DriverManager.getConnection(url, username, password);
		return conn;
	}

	// 关闭数据库连接，释放资源
	public static void release(PreparedStatement ps, Connection conn,
 			ResultSet rs) {
 		if (ps != null) {
 			try {
 				ps.close();
 			} catch (SQLException e) {
 				e.printStackTrace();
 			}
 			ps = null;
 		}
 		if (conn != null) {
 			try {
 				conn.close();
 			} catch (SQLException e) {
 				e.printStackTrace();
 			}
 			conn = null;
 		}
 		if (rs != null) {
 			try {
 				rs.close();
 			} catch (SQLException e) {
 				e.printStackTrace();
 			}
 			rs = null;
 		}

}
}