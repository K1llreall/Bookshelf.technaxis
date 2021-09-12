package com.technaxis.Bookshelf.service;

import com.technaxis.Bookshelf.model.Book;

import java.util.List;

public interface BookService {
    Book getById(Long id);
    void save(Book book);
    void delete(Long id);
    List<Book> getAll();

}
