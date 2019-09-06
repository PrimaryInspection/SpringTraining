package ua.mishko.training.service;

import ua.mishko.training.model.Book;

import java.util.List;

public interface BookService {
    void addBook(Book book);
    void removeBook(Long id);
    void updateBook(Book book);
    Book getBookById(Long id);
    List<Book> getAllBooks();
}
