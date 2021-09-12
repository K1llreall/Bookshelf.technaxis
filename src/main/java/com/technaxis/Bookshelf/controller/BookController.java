package com.technaxis.Bookshelf.controller;


import com.technaxis.Bookshelf.model.Book;
import com.technaxis.Bookshelf.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("books")
public class BookController {

    @Autowired
    private BookService bookService;


    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Book> getBook(@PathVariable("id") Long bookId) {
        if (bookId == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Book book = this.bookService.getById(bookId);
        if (book == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(book,HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Book> saveBook(@RequestBody @Validated Book book) {
        HttpHeaders headers = new HttpHeaders();

        if (book == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(value = "", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Book> updateBook(@RequestBody @Validated Book book, UriComponentsBuilder builder) {
        if (book == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        this.bookService.save(book);

        return new ResponseEntity<>(book, HttpStatus.OK);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Book> deleteBook(@PathVariable("{id}") Long id) {
        Book book = this.bookService.getById(id);

        if (book == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        this.bookService.delete(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Book>> getAllBooks() {
        List<Book> books = this.bookService.getAll();

        if (books.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(books, HttpStatus.OK);
    }


}
