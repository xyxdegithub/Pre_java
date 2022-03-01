package com.xyx.repository.impl;

import com.xyx.entity.Book;
import com.xyx.entity.BookCase;
import com.xyx.repository.BookRepository;
import com.xyx.utils.JDBCTools;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author :xyx
 * @date :2021/5/10 16:52
 * @description:TODO
 * @
 */
public class BookRepositoryImpl implements BookRepository {

    private Connection connection = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;


    @Override
    public List<Book> queryAll(int index, int limit) {
        List<Book> bookList = new ArrayList<>();
        connection = JDBCTools.getConnection();
        //sql语句是很重要的(这是双表查询)   0下标 长度为10
        //int count = 10;//设置每页显示几条
        String sql = "select * from book,bookcase where book.bookcaseid=bookcase.id limit ?,?";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, index);
            preparedStatement.setInt(2, limit);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int bookcaseId = resultSet.getInt(9);
                String bookcaseName = resultSet.getString(10);
                BookCase bookCase = new BookCase(bookcaseId, bookcaseName);
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String author = resultSet.getString(3);
                String publish = resultSet.getString(4);
                int pages = resultSet.getInt(5);
                double price = resultSet.getDouble(6);
                Book book = new Book(id, name, author, publish, pages, price, bookCase);
                boolean flag = bookList.add(book);
                if (flag == true) {
                    System.out.println("加入图书成功");
                } else {
                    System.out.println("加入图书失败");
                }

            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCTools.release(connection,preparedStatement,resultSet);
        }
        return bookList;
    }

    @Override
    public int getCount() {
        int count = 0;
        connection = JDBCTools.getConnection();

        String sql = "select count(*) from book,bookcase where book.bookcaseid=bookcase.id";

        try {
            preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                count = resultSet.getInt(1);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCTools.release(connection,preparedStatement,resultSet);
        }
        return count;
    }
}
