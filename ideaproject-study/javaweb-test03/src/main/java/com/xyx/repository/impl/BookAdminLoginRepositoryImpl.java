package com.xyx.repository.impl;

import com.xyx.entity.BookAdmin;
import com.xyx.entity.Reader;
import com.xyx.repository.BookAdminLoginRepository;
import com.xyx.utils.JDBCTools;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author :xyx
 * @date :2021/5/9 19:45
 * @description:TODO
 * @
 */
public class BookAdminLoginRepositoryImpl implements BookAdminLoginRepository {
    private Connection connection = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

    @Override
    public BookAdmin login(String username, String password) {
        BookAdmin bookAdmin = null;
        connection = JDBCTools.getConnection();
        String sql = "select * from bookadmin where username=? and password=?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String uName = resultSet.getString(2);
                String uPassword = resultSet.getString(3);

                bookAdmin = new BookAdmin(id, uName, uPassword);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCTools.release(connection, preparedStatement, resultSet);
        }
        return bookAdmin;

    }
}
