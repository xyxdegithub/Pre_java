package com.xyx.repository.impl;

import com.xyx.entity.Reader;
import com.xyx.repository.ReaderLoginRepository;
import com.xyx.utils.JDBCTools;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author :xyx
 * @date :2021/5/9 18:12
 * @description:TODO
 * @
 */
public class ReaderLoginRepositoryImpl implements ReaderLoginRepository {

    private Connection connection = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

    @Override
    public Reader login(String username, String password) {
        Reader reader = null;
        connection = JDBCTools.getConnection();
        String sql = "select * from reader where username=? and password=?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String uName = resultSet.getString(2);
                String uPassword = resultSet.getString(3);
                String name = resultSet.getString(4);
                String tel = resultSet.getString(5);
                String cardId = resultSet.getString(6);
                String gender = resultSet.getString(7);

                reader = new Reader(id, uName, uPassword, name, tel, cardId, gender);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCTools.release(connection, preparedStatement, resultSet);
        }
        return reader;
    }

}
