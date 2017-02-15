package com.epam.library.dao;

public interface BookActionDAO {

    void createBook(String name, String author, int year);
    void readBook(int id);
    void readBook();
    void updateBook();
    void deleteBook(int id);
}
