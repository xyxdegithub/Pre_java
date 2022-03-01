package com.xyx.repository.impl;

import com.xyx.entity.AdminCheckBorrow;
import com.xyx.entity.Book;
import com.xyx.entity.Reader;
import com.xyx.entity.vo.BorrowedBook;
import com.xyx.repository.BorrowRepository;
import com.xyx.utils.JDBCTools;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author :xyx
 * @date :2021/6/6 0:31
 * @description:TODO
 * @
 */
public class BorrowRepositoryImpl implements BorrowRepository {

    private Connection connection = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

    @Override
    public void borrowBook(Integer bookId, Integer readerId, String borrowStr,
                           String returnStr, Integer adminId, Integer state) {
        connection = JDBCTools.getConnection();
        //如果一个值为null，不用set
        String sql = "insert into borrow(bookid,readerid,borrowtime,returntime,state) values(?,?,?,?,?)";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, bookId);
            preparedStatement.setInt(2, readerId);
            preparedStatement.setString(3, borrowStr);
            preparedStatement.setString(4, returnStr);
            preparedStatement.setInt(5, state);
            int i = preparedStatement.executeUpdate();
            if (i > 0) {
                System.out.println("用户借书成功!");
            } else {
                System.out.println("用户借书失败!");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCTools.release(connection, preparedStatement, resultSet);
        }

    }

    @Override
    public List<BorrowedBook> queryAllBorrowedBookByReaderId(Integer readerId, Integer index, Integer limit) {
        List borrowedBookArrayList = new ArrayList<BorrowedBook>();
        connection = JDBCTools.getConnection();
        //多表查询有难度,sql语句比较长
        String sql = "select borrow.id,book.name,book.author,book.publish," +
                "reader.`name`,reader.tel,reader.cardid," +
                "borrow.borrowtime,borrow.returntime,borrow.state" +
                " from borrow,book,reader " +
                "where readerid=? and borrow.bookid=book.id and borrow.readerid=reader.id limit ?,?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, readerId);
            preparedStatement.setInt(2, index);
            preparedStatement.setInt(3, limit);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String author = resultSet.getString(3);
                String publish = resultSet.getString(4);
                String readerName = resultSet.getString(5);
                int tel = resultSet.getInt(6);
                int cardId = resultSet.getInt(7);
                String borrowTime = resultSet.getString(8);
                String returnTime = resultSet.getString(9);
                int state = resultSet.getInt(10);
                BorrowedBook borrowedBook = new BorrowedBook(id, name, author, publish,
                        readerName, tel, cardId, borrowTime, returnTime, state);
                borrowedBookArrayList.add(borrowedBook);
                System.out.println(borrowedBook);

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCTools.release(connection, preparedStatement, resultSet);
        }
        return borrowedBookArrayList;
    }

    @Override
    public int getCount(Integer readerId) {
        int count = 0;
        connection = JDBCTools.getConnection();
        String sql = "select count(*) " +
                " from borrow,book,reader " +
                "where readerid=? and borrow.bookid=book.id and borrow.readerid=reader.id;";
        try {
            //查询得到结果集
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, readerId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                count = resultSet.getInt(1);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCTools.release(connection, preparedStatement, resultSet);
        }

        return count;
    }

    @Override
    public List<AdminCheckBorrow> queryBorrowedBookByState(Integer state, Integer index, Integer limit) {
        List adminCheckBorrowArrayList = new ArrayList<AdminCheckBorrow>();
        connection = JDBCTools.getConnection();
        //多表查询有难度,sql语句比较长
        String sql = "select borrow.id,book.name,book.author," +
                "reader.`name`,reader.cardid,reader.tel," +
                "borrow.borrowtime,borrow.returntime" +
                " from borrow,book,reader " +
                "where state=? and borrow.bookid=book.id and borrow.readerid=reader.id limit ?,?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, state);
            preparedStatement.setInt(2, index);
            preparedStatement.setInt(3, limit);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String bookName = resultSet.getString(2);
                String bookAuthor = resultSet.getString(3);
                Book book = new Book(bookName, bookAuthor);
                String readerName = resultSet.getString(4);
                String readerCardId = resultSet.getString(5);
                String readerTel = resultSet.getString(6);
                Reader reader = new Reader(readerName, readerCardId, readerTel);
                String borrowTime = resultSet.getString(7);
                String returnTime = resultSet.getString(8);
                adminCheckBorrowArrayList.add(new AdminCheckBorrow(id, book, reader, borrowTime, returnTime));

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCTools.release(connection, preparedStatement, resultSet);
        }
        return adminCheckBorrowArrayList;
    }

    @Override
    public List<BorrowedBook> queryBorrowedBookByState2(Integer state, Integer index, Integer limit) {
        List borrowedBookArrayList = new ArrayList<BorrowedBook>();
        connection = JDBCTools.getConnection();
        //多表查询有难度,sql语句比较长
        String sql = "select borrow.id,book.name,book.author,book.publish," +
                "reader.`name`,reader.cardid,reader.tel," +
                "borrow.borrowtime,borrow.returntime" +
                " from borrow,book,reader " +
                "where state=? and borrow.bookid=book.id and borrow.readerid=reader.id limit ?,?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, state);
            preparedStatement.setInt(2, index);
            preparedStatement.setInt(3, limit);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String author = resultSet.getString(3);
                String publish = resultSet.getString(4);
                String readerName = resultSet.getString(5);
                int tel = resultSet.getInt(6);
                int cardId = resultSet.getInt(7);
                String borrowTime = resultSet.getString(8);
                String returnTime = resultSet.getString(9);

                BorrowedBook borrowedBook = new BorrowedBook(id, name, author, publish,
                        readerName, tel, cardId, borrowTime, returnTime, null);
                borrowedBookArrayList.add(borrowedBook);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCTools.release(connection, preparedStatement, resultSet);
        }
        return borrowedBookArrayList;
    }

    @Override
    public int getCountAdminCheck(Integer state) {
        int count = 0;
        connection = JDBCTools.getConnection();
        String sql = "select count(*) " +
                " from borrow,book,reader " +
                "where state=? and borrow.bookid=book.id and borrow.readerid=reader.id;";
        try {
            //查询得到结果集
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, state);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                count = resultSet.getInt(1);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCTools.release(connection, preparedStatement, resultSet);
        }
        return count;
    }

    @Override
    public void checkBorrowedBook(Integer borrowedBookId, Integer state, Integer adminId) {
        connection = JDBCTools.getConnection();
        String sql = "update borrow set adminid=?,state=? where id=?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, adminId);
            preparedStatement.setInt(2, state);
            preparedStatement.setInt(3, borrowedBookId);
            int count = preparedStatement.executeUpdate();
            if (count == 1) {
                System.out.println("更新成功!");
            } else {
                System.out.println("更新失败!");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCTools.release(connection, preparedStatement, null);
        }
    }
}
