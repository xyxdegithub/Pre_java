package my.servlet;

import java.sql.SQLException;

import my.dao.DBCPUtilDAO;
import my.entity.User;

public class Service {
          public static void main(String[] args) throws SQLException {
			User u=new User("1","朱重八","800");
			DBCPUtilDAO.insert(u);
			User u2=new User("2","温狗熊","1");
			DBCPUtilDAO.insert(u2);
			DBCPUtilDAO.showAll();
		}
} 
