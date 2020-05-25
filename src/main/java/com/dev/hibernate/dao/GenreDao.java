package com.dev.hibernate.dao;

import com.dev.hibernate.model.Genre;

import java.util.List;

public interface GenreDao {

    Genre add(Genre genre);

    boolean delete(Genre genre);

    List<Genre> getAll();
}
