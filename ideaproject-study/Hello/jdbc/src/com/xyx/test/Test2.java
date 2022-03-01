package com.xyx.test;

import java.sql.*;

/**
 * @author :xyx
 * @date :2021/4/29 21:14
 * @description:TODO
 * @
 */
public class Test2 {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/" +
                    "jdbc?useUnicode=true&characterEncoding=utf-8&serverTimezone=Asia/Shanghai";
            String userName = "root";
            String password = "123456";
            Connection connection = DriverManager.getConnection(url, userName, password);

            String name = "lisi";
            int age = 18;
            String sql = "select * from user2 where name=? and age=?";
            //用PreparedStatement防止sql注入
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, age);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                System.out.println("查找成功!");
            } else {
                System.out.println("查找失败!");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

    }

}
