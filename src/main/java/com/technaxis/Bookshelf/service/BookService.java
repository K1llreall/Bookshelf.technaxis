package com.technaxis.Bookshelf.service;

import com.technaxis.Bookshelf.controller.dto.BookPaginationDto;
import com.technaxis.Bookshelf.model.Book;
import org.springframework.data.domain.Page;

public interface BookService {
    Book getById(Long id);
    void save(Book book);
    void delete(Long id);
    Page<Book> getAll(BookPaginationDto dto);

}
