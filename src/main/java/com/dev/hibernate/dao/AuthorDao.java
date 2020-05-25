package com.dev.hibernate.dao;

import com.dev.hibernate.model.Author;

import java.util.List;

public interface AuthorDao {

    Author add(Author author);

    boolean delete(Author author);

    List<Author> getAll();
}
