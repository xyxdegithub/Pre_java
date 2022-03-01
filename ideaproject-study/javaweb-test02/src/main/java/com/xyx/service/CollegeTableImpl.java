package com.xyx.service;

import com.xyx.entity.CollegeTable;
import com.xyx.entity.User;
import com.xyx.util.JDBCUtil2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author :xyx
 * @date :2021/5/7 16:41
 * @description:TODO
 * @
 */
public class CollegeTableImpl {

    public List<CollegeTable> showAll() {
        List<CollegeTable> collegeTableListList = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = JDBCUtil2.GetConnection();
            String sql = "select * from toudangbiao";
            preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int rowId = resultSet.getInt(1);
                String category = resultSet.getString(2);
                int collegeId = resultSet.getInt(3);
                String collegeName = resultSet.getString(4);
                int score = resultSet.getInt(5);
                int rank = resultSet.getInt(6);
                CollegeTable collegeTable = new CollegeTable(rowId, category, collegeId, collegeName, score, rank);
                collegeTableListList.add(collegeTable);
            }
            return collegeTableListList;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

}
