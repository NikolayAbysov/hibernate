package com.dev.hibernate.service.impl;

import com.dev.hibernate.dao.BookDao;
import com.dev.hibernate.lib.anno.Inject;
import com.dev.hibernate.lib.anno.Service;
import com.dev.hibernate.model.Book;
import com.dev.hibernate.service.BookService;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Inject
    private BookDao bookDao;

    @Override
    public Book add(Book book) {
        return bookDao.add(book);
    }

    @Override
    public List<Book> getAll() {
        return bookDao.getAll();
    }
}
