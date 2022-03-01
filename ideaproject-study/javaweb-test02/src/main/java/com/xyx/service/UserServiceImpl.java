package com.xyx.service;

import com.xyx.entity.User;
import com.xyx.util.JDBCUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author :xyx
 * @date :2021/5/1 16:37
 * @description:TODO
 * @
 */
public class UserServiceImpl {
    public List<User> findAll() {
        List<User> usersList = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            /*Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/" +
                    "jdbc?useUnicode=true&characterEncoding=utf-8&serverTimezone=Asia/Shanghai&useSSL=false";
            String userName = "root";
            String password = "123456";

            connection = DriverManager.getConnection(url, userName, password);*/
            connection = JDBCUtil.GetConnection();
            String sql = "select * from user2";
            preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            User user = null;
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                int age = resultSet.getInt(3);
                user = new User(id, name, age);
                usersList.add(user);
            }
            return usersList;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
                preparedStatement.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }
        return null;
    }

    public void addUser(Integer id, String name, Integer age) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
          /*  Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/" +
                    "jdbc?useUnicode=true&characterEncoding=utf-8&serverTimezone=Asia/Shanghai&useSSL=false";
            String userName = "root";
            String password = "123456";

            connection = DriverManager.getConnection(url, userName, password);*/
            connection = JDBCUtil.GetConnection();
            String sql = "insert into user2(id,name,age) values(?,?,?)";
            preparedStatement = connection.prepareStatement(sql);
            /*先执行语句在插入数据*/
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, name);
            preparedStatement.setInt(3, age);
            int count = preparedStatement.executeUpdate();
            if (count == 1) {
                System.out.println("插入数据成功!");
            } else {
                System.out.println("插入数据失败!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
                preparedStatement.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }

    }

    public void deleteById(Integer id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
           /* Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/" +
                    "jdbc?useUnicode=true&characterEncoding=utf-8&serverTimezone=Asia/Shanghai&useSSL=false";
            String userName = "root";
            String password = "123456";

            connection = DriverManager.getConnection(url, userName, password);*/
            connection = JDBCUtil.GetConnection();
            String sql = "delete from user2 where id=" + id;
            System.out.println(sql);
            preparedStatement = connection.prepareStatement(sql);
            int count = preparedStatement.executeUpdate();
            if (count == 1) {
                System.out.println("删除数据成功!");
            } else {
                System.out.println("删除数据失败!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
                preparedStatement.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }
    }

    public User findById(Integer id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = JDBCUtil.GetConnection();
            String sql = "select * from user2 where id=" + id;
            System.out.println(sql);
            preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int anInt = resultSet.getInt(1);
                String string = resultSet.getString(2);
                int anInt1 = resultSet.getInt(3);
                User user = new User(anInt, string, anInt1);
                System.out.println("查找数据成功!");
                return user;
            } else {
                System.out.println("查找数据失败!");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
                preparedStatement.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }
        return null;
    }

}
