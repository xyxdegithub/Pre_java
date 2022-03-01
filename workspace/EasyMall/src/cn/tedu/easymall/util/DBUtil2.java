package cn.tedu.easymall.util;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbcp.BasicDataSource;

public class DBUtil2 {
	
	// 创建数据库连接池对象
	private static BasicDataSource dataSource=new BasicDataSource();
	
	static{
		// 初始化数据库连接池  ///默认省略localhost:3306
		dataSource.setUrl("jdbc:mysql:///easymalldb");
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUsername("root");
		dataSource.setPassword("123456");
		dataSource.setInitialSize(3);//初始化3个空闲连接
		dataSource.setMaxActive(6);// 最大的活跃连接数量
	}
	
	
	/**
	 * 从数据库连接池中获取一个空闲连接
	 * @return 数据库连接对象
	 * @throws SQLException
	 */
	public static Connection getConn() throws SQLException{
		return dataSource.getConnection();
	}
	
}
