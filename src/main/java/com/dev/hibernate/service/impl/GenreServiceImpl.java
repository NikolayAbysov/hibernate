package com.dev.hibernate.service.impl;

import com.dev.hibernate.dao.GenreDao;
import com.dev.hibernate.lib.anno.Inject;
import com.dev.hibernate.lib.anno.Service;
import com.dev.hibernate.model.Genre;
import com.dev.hibernate.service.GenreService;
import java.util.List;

@Service
public class GenreServiceImpl implements GenreService {
    @Inject
    private GenreDao genreDao;

    @Override
    public Genre add(Genre genre) {
        return genreDao.add(genre);
    }

    @Override
    public boolean delete(Genre genre) {
        return genreDao.delete(genre);
    }

    @Override
    public List<Genre> getAll() {
        return genreDao.getAll();
    }
}
