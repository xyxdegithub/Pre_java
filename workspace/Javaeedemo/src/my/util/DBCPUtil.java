package my.util;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSourceFactory;

public class DBCPUtil {
	private static DataSource ds;// 定义一个连接池对象
	static {
		try {
			Properties pro = new Properties();
			pro.load(DBCPUtil.class.getClassLoader()
					.getResourceAsStream("dbcpconfig.properties"));
			// 得到一个连接池对象
			ds = BasicDataSourceFactory.createDataSource(pro);
		} catch (Exception e) {
			throw new ExceptionInInitializerError("初始化连接错误，请检查配置文件！");
		}
	}

	// 从池中获取一个连接
	public static Connection getConnection() throws SQLException {
		return ds.getConnection();
	}

	public static void closeConn(Connection conn) {
		if (conn != null) {
			try {
				conn.close();// 关闭
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
