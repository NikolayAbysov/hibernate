package com.dev.hibernate.dao.impl;

import com.dev.hibernate.dao.AuthorDao;
import com.dev.hibernate.exception.DataProcessingException;
import com.dev.hibernate.lib.anno.Dao;
import com.dev.hibernate.model.Author;
import com.dev.hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

@Dao
public class AuthorDaoImpl implements AuthorDao {
    @Override
    public Author add(Author author) {
        Transaction transaction = null;
        Session session = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            Long authorId = (Long) session.save(author);
            transaction.commit();
            author.setId(authorId);
            return author;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataProcessingException("Error while adding author. Stacktrace: "
                    + e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public List<Author> getAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            CriteriaQuery<Author> criteriaQuery = session.getCriteriaBuilder().createQuery(Author.class);
            criteriaQuery.from(Author.class);
            return session.createQuery(criteriaQuery).getResultList();
        }catch (Exception e) {
            throw new DataProcessingException("Error while getting list authors. Stacktrace: "
                    + e.getMessage());
        }
    }
}
