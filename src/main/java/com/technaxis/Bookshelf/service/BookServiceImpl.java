package com.technaxis.Bookshelf.service;

import com.technaxis.Bookshelf.model.Book;
import com.technaxis.Bookshelf.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class BookServiceImpl implements BookService {

    @Autowired
    BookRepository bookRepository;

    @Override
    public Book getById(Long id) {
        Optional<Book> bookOptional= bookRepository.findById(id);
        if(bookOptional.isPresent() ){
            return bookOptional.get();
        } else return null;
    }

    @Override
    public void save(Book book) {
        bookRepository.save(book);
    }

    @Override
    public void delete(Long id) {
        bookRepository.delete(getById(id));
    }

    @Override
    public List<Book> getAll() {
        return bookRepository.findAll();
    }
}
