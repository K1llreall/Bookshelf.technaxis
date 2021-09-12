package com.technaxis.Bookshelf.repository;

import com.technaxis.Bookshelf.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface BookRepository extends PagingAndSortingRepository<Book,Long> {
    Page<Book> findAll(Pageable pageable);
    Page<Book> findAllByTitleContainsIgnoreCase(Pageable pageable, String title);
}