package com.epam.library.service;

import com.epam.library.dao.DAOImpl.BookDaoImpl;

public class JournalServiceImpl implements JournalService{

    private BookDaoImpl bookDao = new BookDaoImpl();

    private static final String READ_MORE_THEN_ONE = "select name, count(employee_book.id_employee) as quantity from corporatebooksdb.employee join corporatebooksdb.employee_book on employee_book.id_employee=employee.id_employee group by employee_book.id_employee";

    @Override
    public void readMoreOne() {
    }

    @Override
    public void readLessTwo() {

    }

    @Override
    public void renameBook(String oldName, String newName){
        bookDao.updateTitle(oldName, newName);
    }
}
