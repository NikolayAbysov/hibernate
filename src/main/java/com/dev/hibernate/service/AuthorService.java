package com.dev.hibernate.service;

import com.dev.hibernate.model.Author;

import java.util.List;

public interface AuthorService {

    Author add(Author author);

    boolean delete(Author author);

    List<Author> getAll();
}
