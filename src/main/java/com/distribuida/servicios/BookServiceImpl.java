package com.distribuida.servicios;

import com.distribuida.config.Postgres;
import com.distribuida.db.Book;
import com.distribuida.repository.BookDao;
import jakarta.enterprise.context.ApplicationScoped;
import org.jdbi.v3.core.Jdbi;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class BookServiceImpl implements BookService{

    List<Book> books = new ArrayList<>();
    Postgres postgres = new Postgres();
    Jdbi jdbi = postgres.getJdbi();
   public Book findByID(Integer id){
       return jdbi.withExtension(BookDao.class, dao -> dao.findById(id));
   };
    public List<Book> findAll() {
        books = jdbi.withExtension(BookDao.class, BookDao::listBooks);
    return books;
    }
    public void addBook(Book book) {
        System.out.println(book.getIsbn());
        jdbi.useExtension(BookDao.class, dao -> dao.insert(book.getIsbn(), book.getTitle(), book.getAuthor(), book.getPrice()));
    }
    public void updateBook(Integer id, Book book) {
        jdbi.useExtension(BookDao.class, dao -> dao.update(book.getIsbn(), book.getTitle(), book.getAuthor(), book.getPrice(), id));
    }
    public void deleteBook(Integer id) {
        jdbi.useExtension(BookDao.class, dao -> dao.delete(id));
    }

}
