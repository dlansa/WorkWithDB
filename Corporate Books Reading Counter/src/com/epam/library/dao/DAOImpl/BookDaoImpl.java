package com.epam.library.dao.DAOImpl;

import com.epam.library.dao.BaseDao;
import com.epam.library.dao.BookDao;
import com.epam.library.domain.Author;
import com.epam.library.domain.Book;
import com.epam.library.domain.Entity;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDaoImpl implements BookDao, BaseDao {

    private static final String URL = "jdbc:mysql://localhost:3306/corporatebooksdb?useSSL=false";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "01236589aA!";

    private static final String SELECT_ALL_BOOKS = "select * from books";
    private static final String SELECT_BOOK_BY_TITLE = "select * from books where title = ?";
    private static final String CREATE_BOOK = "insert into books (title, author, year) values (?, ?, ?)";
    private static final String FIND_BY_ID = "select * from books where id_book = ?";
    private static final String DELETE_BY_ID = "delete from books where id_book = ?";
    private static final String UPDATE_BOOK_TITLE = "update books set title = ? where title = ?";

    @Override
    public Book fetchByTitle(String title) {

        Book book = new Book();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            statement = connection.prepareStatement(SELECT_BOOK_BY_TITLE);
            statement.setString(1, title);
            resultSet = statement.executeQuery();
            book.setId(resultSet.getInt("id_book"));
            book.setTitle(resultSet.getString("title"));
            book.setPublishYear(resultSet.getInt("year"));
        } catch (SQLException e) {
            e.getMessage();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.getMessage();
            }
        }
        return book;
    }

    @Override
    public List<Book> findAll() {

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Book> books = null;

        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            statement = connection.prepareStatement(SELECT_ALL_BOOKS);
            resultSet = statement.executeQuery();
            books = new ArrayList<Book>();

            while (resultSet.next()) {
                Book book = new Book();
                book.setId(resultSet.getInt("id_book"));
                book.setTitle(resultSet.getString("title"));
                book.setPublishYear(resultSet.getInt("year"));
                books.add(book);
            }
        } catch (SQLException e) {
            e.getMessage();
        } finally {
            if (connection != null)
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.getMessage();
                }
        }
        return books;
    }

    @Override
    public Book findByID(int id) {

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Book> books = null;
        Book book = new Book();

        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            statement = connection.prepareStatement(FIND_BY_ID);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            book.setTitle(resultSet.getString("title"));
            book.setPublishYear(resultSet.getInt("year"));
            book.setId(resultSet.getInt("id_book"));
            return book;
        } catch (SQLException e) {
            e.getMessage();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.getMessage();
            }
        }

        return book;
    }

    @Override
    public boolean updateTitle(String oldTitle, String newTitle) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            statement = connection.prepareStatement(UPDATE_BOOK_TITLE);
            statement.setString(1, newTitle);
            statement.setString(2, oldTitle);
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            statement = connection.prepareStatement(DELETE_BY_ID);
            statement.setInt(1, id);
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.getMessage();
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.getMessage();
            }
        }
        return false;
    }

    @Override
    public int create(Book book) {

        int year = book.getPublishYear();
        String title = book.getTitle();
        //int authorID = book.getAuthor().getId();
        int authorID = 0;
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            statement = connection.prepareStatement(CREATE_BOOK);
            statement.setString(1, title);
            statement.setInt(2, authorID);
            statement.setInt(3, year);
            resultSet = statement.executeQuery();
        } catch (SQLException e) {
            e.getMessage();
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.getMessage();
            }
        }
        return book.getId();
    }

}
