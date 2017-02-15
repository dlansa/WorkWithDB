package com.epam.library.dao.actionImpl;

import com.epam.library.dao.BookActionDAO;
import com.epam.library.domain.Book;
import com.epam.library.domain.DBconnector;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookActionDAOImpl implements BookActionDAO {

    private DBconnector connector;
    private ResultSet resultSet;
    private PreparedStatement preparedStatement;

    public BookActionDAOImpl(){
        connector = new DBconnector();
    }

    @Override
    public void createBook(String name, String author, int year) {
        try {
            preparedStatement = connector.getConnection().
                    prepareStatement("insert into books (briefe, author, year) values ('"+name+"', '"+author+"', '"+year+"')");
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.getMessage();
        }
    }

    @Override
    public void readBook(int id) {
        try {
            preparedStatement = connector.getConnection().prepareStatement("select * from books where id_book = "+id+"");
            resultSet = preparedStatement.executeQuery();
            Book book = new Book();
            book.setAuthor(resultSet.getString("author"));
            book.setTitle(resultSet.getString("briefe"));
            book.setDateOfPublishing(resultSet.getInt("year"));
            book.setId(resultSet.getInt("id_book"));
            System.out.println(book);
        } catch (SQLException e) {
            e.getMessage();
        }
    }

    public void readBook() {

        try {
            preparedStatement = connector.getConnection().prepareStatement("select * from books");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Book book = new Book();
                book.setAuthor(resultSet.getString("author"));
                book.setTitle(resultSet.getString("briefe"));
                book.setDateOfPublishing(resultSet.getInt("year"));
                book.setId(resultSet.getInt("id_book"));
                System.out.println(book);
            }
        } catch (SQLException e) {
            e.getMessage();
        }
    }

    @Override
    public void updateBook() {

    }

    @Override
    public void deleteBook(int id) {

        try {
            preparedStatement = connector.getConnection().prepareStatement("delete from books where id_book='"+id+"'");
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.getMessage();
        }
    }

}
