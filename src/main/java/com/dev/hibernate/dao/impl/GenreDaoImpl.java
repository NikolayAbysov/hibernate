package com.dev.hibernate.dao.impl;

import com.dev.hibernate.dao.GenreDao;
import com.dev.hibernate.exception.DataProcessingException;
import com.dev.hibernate.lib.anno.Dao;
import com.dev.hibernate.model.Genre;
import com.dev.hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

@Dao
public class GenreDaoImpl implements GenreDao {
    @Override
    public Genre add(Genre genre) {
        Transaction transaction = null;
        Session session = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            Long genreId = (Long) session.save(genre);
            transaction.commit();
            genre.setId(genreId);
            return genre;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataProcessingException("Error while adding genre. Stacktrace: "
                    + e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public List<Genre> getAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            CriteriaQuery<Genre> criteriaQuery = session.getCriteriaBuilder().createQuery(Genre.class);
            criteriaQuery.from(Genre.class);
            return session.createQuery(criteriaQuery).getResultList();
        }catch (Exception e) {
            throw new DataProcessingException("Error while getting list genres. Stacktrace: "
                    + e.getMessage());
        }
    }
}
