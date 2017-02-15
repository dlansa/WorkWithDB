package com.epam.library.domain;

import java.sql.*;

public class DBconnector {

    private static final String URL = "jdbc:mysql://localhost:3306/corporatebooksdb?useSSL=false";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "01236589aA!";
    private Connection connection;
    private ResultSet resultSet;
    private Statement statement;

    public DBconnector(){
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.getMessage();
        }
    }

    public Statement getStatement() {
        return statement;
    }

    public Connection getConnection() {
        return connection;
    }
}
