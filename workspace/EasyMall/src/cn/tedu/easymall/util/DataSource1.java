package cn.tedu.easymall.util;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class DataSource1 {
	
	private static int initSize=3;
	
	private static List<Connection> pool=new LinkedList<>();
	
	static{// 静态初始化器
		// 一次性创建固定数量的连接
		for(int i=1;i<=initSize;i++){
			try {
				pool.add(DBUtil2.getConn());
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static Connection getConn(){
		if(pool.size()>0){
			return pool.remove(0);
		}
		return null;
	}
	
	public static void returnConn(Connection conn){
		pool.add(conn);
	}
}
