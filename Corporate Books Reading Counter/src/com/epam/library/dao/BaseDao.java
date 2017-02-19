package com.epam.library.dao;

import com.epam.library.domain.Book;
import com.epam.library.domain.Entity;

import java.util.List;

public interface BaseDao {


    Book findByID(int id);
    boolean delete(int id);
}
