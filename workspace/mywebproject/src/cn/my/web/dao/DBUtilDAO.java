package cn.my.web.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;





import cn.my.web.entity.User;
import cn.my.web.util.DBUtil;

public class DBUtilDAO {
          public static boolean insert(User u) {
        	  Connection conn;
			try {
				conn = DBUtil.getConn();
				String sql="insert into t_user values(null,?,?,?,?)";
				PreparedStatement ps=conn.prepareStatement(sql);
      		    ps.setString(1, u.getUsername());
      		    ps.setString(2, u.getPassword());
      		    ps.setString(3, u.getEmail());
      		    ps.setString(4, u.getPhone());
      		    ps.executeUpdate();
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
}
