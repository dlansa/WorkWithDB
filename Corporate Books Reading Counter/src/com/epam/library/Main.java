package com.epam.library;

import com.epam.library.dao.BookActionDAO;
import com.epam.library.dao.actionImpl.BookActionDAOImpl;
import com.epam.library.domain.DBconnector;

import java.sql.*;

public class Main {

    public static void main(String[] args) {

        BookActionDAO action = new BookActionDAOImpl();

        action.readBook(2);
        //action.createBook("test", "test", 2017);
        //action.deleteBook(103);
        //action.readBook();

    }
}
