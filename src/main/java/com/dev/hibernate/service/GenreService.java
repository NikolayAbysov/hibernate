package com.dev.hibernate.service;

import com.dev.hibernate.model.Genre;

import java.util.List;

public interface GenreService {

    Genre add(Genre genre);

    boolean delete(Genre genre);

    List<Genre> getAll();
}
