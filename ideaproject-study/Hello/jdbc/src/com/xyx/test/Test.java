package com.xyx.test;

import java.sql.*;

/**
 * @author :xyx
 * @date :2021/4/29 20:27
 * @description:TODO
 * @
 */
public class Test {

    public static void main(String[] args) {
        try {
            //反射机制加载驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            //连接
            String url = "jdbc:mysql://localhost:3306/" +
                    "jdbc?useUnicode=true&characterEncoding=utf-8&serverTimezone=Asia/Shanghai";
            String userName = "root";
            String password = "123456";
            Connection connection = DriverManager.getConnection(url, userName, password);
            System.out.println(connection);

            //执行语句
            //如果id是主键自增不用
            String sql = "insert into user(id,name,password,email,birthday) " +
                    "values(5,'陈独秀','123456','123456@qq.com','1921-07-21')";
            String sql2 = "delete from user where id=5";
            String sql3 = "select * from user";
            Statement statement = connection.createStatement();
            //执行并更新
            int row = statement.executeUpdate(sql);//增删改操作
            System.out.println(row);
            //查的结果resultSet接收
            ResultSet resultSet = statement.executeQuery(sql3);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String password1 = resultSet.getString("password");
                String email = resultSet.getString("email");
                String birthday = resultSet.getString("birthday");
                System.out.println("["+id+"-"+name+"-"+password1+"-"+email+"-"+birthday+"]");

            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
