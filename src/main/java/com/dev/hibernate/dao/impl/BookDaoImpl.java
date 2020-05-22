package com.dev.hibernate.dao.impl;

import com.dev.hibernate.dao.BookDao;
import com.dev.hibernate.exception.DataProcessingException;
import com.dev.hibernate.lib.anno.Dao;
import com.dev.hibernate.model.Book;
import com.dev.hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

@Dao
public class BookDaoImpl implements BookDao {
    @Override
    public Book add(Book book) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            Long bookId = (Long) session.save(book);
            transaction.commit();
            book.setId(bookId);
            return book;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataProcessingException("Error while adding book. Stacktrace: "
                    + e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public List<Book> getAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            CriteriaQuery<Book> criteriaQuery = session.getCriteriaBuilder().createQuery(Book.class);
            criteriaQuery.from(Book.class);
            return session.createQuery(criteriaQuery).getResultList();
        }catch (Exception e) {
            throw new DataProcessingException("Error while getting list books. Stacktrace: "
                    + e.getMessage());
        }
    }
}
