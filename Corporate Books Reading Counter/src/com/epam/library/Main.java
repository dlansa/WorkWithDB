package com.epam.library;

import com.epam.library.dao.BookActionDAO;
import com.epam.library.dao.actionImpl.BookActionDAOImpl;
import com.epam.library.domain.DBconnector;
import com.epam.library.service.JournalService;
import com.epam.library.service.journalImpl.JournalServiceImpl;

import java.sql.*;

public class Main {

    public static void main(String[] args) {

        BookActionDAOImpl action = new BookActionDAOImpl();
        JournalService service = new JournalServiceImpl();

        //action.readBook(2);
        //action.createBook("test", "test", 2017);
        //action.deleteBook(101);
        //action.readBook();

        //service.renameBook("Бесы", "Бесы ТЕСТ");
        service.readMoreOne();

    }
}
