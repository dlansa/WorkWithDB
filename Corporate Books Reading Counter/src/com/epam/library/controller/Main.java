package com.epam.library.controller;

import com.epam.library.dao.DAOImpl.BookDaoImpl;

public class Main {

    public static void main(String[] args) {



        //action.readBook(2);
        //action.createBook("test", "test", 2017);
        //action.deleteBook(101);
        //action.readBook();

        //service.renameBook("Бесы", "Бесы ТЕСТ");
        //service.readMoreOne();

        BookDaoImpl bookDao = new BookDaoImpl();

        System.out.println(bookDao.updateTitle("Бесы ТЕСТ", "Бесы"));
    }
}
