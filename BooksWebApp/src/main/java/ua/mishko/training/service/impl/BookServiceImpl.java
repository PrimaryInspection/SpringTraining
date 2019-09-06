package ua.mishko.training.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.mishko.training.dao.BookDao;
import ua.mishko.training.model.Book;
import ua.mishko.training.service.BookService;

import java.util.List;

@Service
@Transactional
public class BookServiceImpl implements BookService {

    private BookDao bookDao;


    public void setBookDao(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    @Override
    public void addBook(Book book) {
    this.bookDao.addBook(book);
    }

    @Override
    public void removeBook(Long id) {
        this.bookDao.removeBook(id);

    }

    @Override
    public void updateBook(Book book) {
        this.bookDao.updateBook(book);

    }

    @Override
    public Book getBookById(Long id) {
       return this.bookDao.getBookById(id);
    }

    @Override
    public List<Book> getAllBooks() {
       return  this.bookDao.getAllBooks();
    }
}
