package com.epam.library.dao;

import com.epam.library.domain.Book;

import java.util.List;

public interface BookDao {

    Book fetchByTitle(String title);
    int create(Book book);
    List<Book> findAll();
    boolean updateTitle(String oldTitle, String newTitle);

}
