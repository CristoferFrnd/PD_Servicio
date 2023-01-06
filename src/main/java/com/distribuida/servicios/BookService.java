package com.distribuida.servicios;

import com.distribuida.db.Book;

import java.util.List;

public interface BookService {
    Book findByID(Integer id);
    List<Book> findAll();
    void addBook(Book book);
    void updateBook(Integer id, Book book);
    void deleteBook(Integer id);

}
