package com.dev.hibernate.service.impl;

import com.dev.hibernate.dao.AuthorDao;
import com.dev.hibernate.lib.anno.Inject;
import com.dev.hibernate.lib.anno.Service;
import com.dev.hibernate.model.Author;
import com.dev.hibernate.service.AuthorService;

import java.util.List;
@Service
public class AuthorServiceImpl implements AuthorService {
    @Inject
    private AuthorDao authorDao;

    @Override
    public Author add(Author author) {
        return authorDao.add(author);
    }

    @Override
    public boolean delete(Author author) {
        return authorDao.delete(author);
    }

    @Override
    public List<Author> getAll() {
        return authorDao.getAll();
    }
}
