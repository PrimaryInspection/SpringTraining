package ua.mishko.training.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import ua.mishko.training.dao.BookDao;
import ua.mishko.training.model.Book;

import java.util.List;

@Repository
public class BookDaoImpl implements BookDao{
    private static final Logger logger = LoggerFactory.getLogger(BookDaoImpl.class);

    private SessionFactory sessionFactory;


    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public void addBook(Book book) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(book);
        logger.info("Book successfully saved. Book details: " + book);
    }

    @Override
    public void removeBook(Long id) {
        Session session = this.sessionFactory.getCurrentSession();
        Book book = (Book) session.load(Book.class,new Long(id));
        if(book != null){
            session.delete(book);
        }
        logger.info("Book was succesfully deleted by id: " + book.getId());
    }

    @Override
    public void updateBook(Book book) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(book);
        logger.info("Book was succesfully edited by id: " + book.getId());
    }

    @Override
    public Book getBookById(Long id) {
        Session session = this.sessionFactory.getCurrentSession();
        Book book = (Book) session.load(Book.class,new Long(id));
        logger.info("Book was succesfully loaded by id: " + book.getId());
        return book;
    }

    @Override
    @SuppressWarnings("all")
    public List<Book> getAllBooks() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Book> bookList = session.createQuery("from Book").list();
        for (Book book : bookList){
            logger.info("Book list: " + book);
        }
        return bookList;
    }
}
