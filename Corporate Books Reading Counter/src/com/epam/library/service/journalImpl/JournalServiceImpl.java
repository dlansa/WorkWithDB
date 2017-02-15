package com.epam.library.service.journalImpl;

import com.epam.library.domain.DBconnector;
import com.epam.library.service.JournalService;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JournalServiceImpl implements JournalService{

    private DBconnector connector;
    private PreparedStatement preparedStatement;
    ResultSet resultSet;

    public JournalServiceImpl(){
        connector = new DBconnector();
    }
/*
1.     View report on the employees who have read more than 1 book
The report should contain the following information:
employee name:  number of books

 */
    @Override
    public void readMoreOne() {
        String query = "select name, count(employee_book.id_employee) as quantity from corporatebooksdb.employee join corporatebooksdb.employee_book on employee_book.id_employee=employee.id_employee  group by employee_book.id_employee";
        try {
            preparedStatement = connector.getConnection().prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String name = resultSet.getString("name");
                int qty = resultSet.getInt("quantity");
                System.out.println(name + ": " + qty);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void readLessTwo() {

    }

    @Override
    public void renameBook(String oldName, String newName){
        try {
            preparedStatement = connector.getConnection().prepareStatement("update books set briefe = '"+newName+"' where briefe = '"+oldName+"'");
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.getMessage();
        }
    }
}
