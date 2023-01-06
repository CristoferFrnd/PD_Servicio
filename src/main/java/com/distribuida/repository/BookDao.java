package com.distribuida.repository;

import com.distribuida.db.Book;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import java.util.List;

public interface BookDao {

    @SqlQuery("SELECT * FROM public.books")
    @RegisterBeanMapper(Book.class)
    List<Book> listBooks();
    @SqlUpdate("INSERT INTO public.books (isbn, title, author, price) VALUES (?, ?, ?, ?)")
    void insert(String isbn, String title, String author, double price);

    @SqlUpdate("UPDATE public.books SET isbn = ?, title = ?, author = ?, price = ? WHERE id = ?")
    void update(String isbn, String title, String author, double price, int id);

    @SqlUpdate("DELETE FROM public.books WHERE id = ?")
    void delete(int id);

    // find by id
    @SqlQuery("SELECT * FROM public.books WHERE id = ?")
    @RegisterBeanMapper(Book.class)
    Book findById(int id);
}
