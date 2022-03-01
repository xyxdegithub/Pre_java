package com.xyx.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author :xyx
 * @date :2021/5/7 15:07
 * @description:TODO
 * @
 */
public class JDBCUtil {


    public static Connection GetConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/" +
                    "jdbc?useUnicode=true&characterEncoding=utf-8&serverTimezone=Asia/Shanghai&useSSL=false";
            String userName = "root";
            String password = "123456";
            Connection connection = DriverManager.getConnection(url, userName, password);
            return connection;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }

}