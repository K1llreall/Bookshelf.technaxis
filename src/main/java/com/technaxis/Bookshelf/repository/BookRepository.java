package com.technaxis.Bookshelf.repository;

import com.technaxis.Bookshelf.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Long> {
}
