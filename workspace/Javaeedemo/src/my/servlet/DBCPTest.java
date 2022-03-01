package my.servlet;

import java.sql.Connection;
import java.sql.SQLException;

import my.util.DBCPUtil;

public class DBCPTest {
	public static void main(String[] args) throws SQLException {
		//输出连接信息
		System.out.println(DBCPUtil.getConnection());
		long begin = System.currentTimeMillis();
		for (int i = 0; i < 10000; i++) {
			Connection conn = DBCPUtil.getConnection();
			DBCPUtil.closeConn(conn);
		}
		long end = System.currentTimeMillis();
		System.out.println("用时：" + (end - begin));
	}


}
