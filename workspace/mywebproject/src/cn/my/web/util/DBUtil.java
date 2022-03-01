package cn.my.web.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public  class DBUtil {
	public static Connection getConn() throws ClassNotFoundException, SQLException {
		 String url="jdbc:mysql://localhost:3306/mywebproject";
		 String username="root";
		 String password="123456";
		//注册驱动
		Class.forName("com.mysql.jdbc.Driver");
		//获得链接
		Connection conn=DriverManager.getConnection(url,username,password);
		return conn;
			
	}
          
}
