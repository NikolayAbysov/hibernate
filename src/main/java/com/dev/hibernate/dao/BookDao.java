package com.dev.hibernate.dao;

import com.dev.hibernate.model.Book;

import java.util.List;

public interface BookDao {

    Book add(Book book);

    List<Book> getAll();
}
