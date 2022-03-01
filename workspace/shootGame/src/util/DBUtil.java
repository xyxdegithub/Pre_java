package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


/**
 * 数据库工具类：提供静态方法用于建立连接和关闭连接
 * 数据库的连接参数通过读取配置文件的方式
 * @author gongdewen
 *
 */
public class DBUtil {
	private static String driverClass;
	private static String url;
	private static String user;
	private static String password;
	
	/**
	 * 静态代码块：在第一次加载类（或使用时）会自动执行（只执行一次）
	 */
	static{
		Properties props=new Properties(); //Properties类用于读取并分析具有key=value格式的配置文件
		try {
			props.load(new FileInputStream("db.properties"));
			driverClass=props.getProperty("driverClass");//得到key为driverClass的值赋给静态变量，下同
			url=props.getProperty("url");
			user=props.getProperty("user");
			password=props.getProperty("password");
//			System.out.println(driverClass);
//			System.out.println(url);
//			System.out.println(user);
//			System.out.println(password);
		} catch (FileNotFoundException e) {
			System.out.println("数据库配置文件不存在");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("加载并分析数据库配置文件失败");
			e.printStackTrace();
		}
	}
	
	/**
	 * 利用参数建立与数据库的连接
	 * @return 返回一个数据库连接对象
	 */
	public static Connection getConnection(){
		Connection conn=null;
		try {
			//1.加载数据库驱动类
			Class.forName(driverClass);
			//2.利用驱动管理类来得到一个数据库连接
			conn=DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			System.out.println("数据库驱动类不存在或错误");
			e.printStackTrace();
		}  catch (SQLException e) {
			System.out.println("数据库建立连接失败");
			e.printStackTrace();
		}
		return conn;
	}
	
	/**
	 * 关闭指定的数据库连接
	 * @param conn 数据库连接对象
	 */
	public static void close(Connection conn){
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				System.out.println("数据库关闭连接失败");
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		Connection conn=DBUtil.getConnection();
		if(conn!=null){
			System.out.println("建立连接成功");
		}
		DBUtil.close(conn); //关闭连接
	}
	
}
