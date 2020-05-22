package com.dev.hibernate.service;

import com.dev.hibernate.model.Book;

import java.util.List;

public interface BookService {

    Book add(Book book);

    List<Book> getAll();
}
