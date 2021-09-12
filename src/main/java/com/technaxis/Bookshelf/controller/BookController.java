package com.technaxis.Bookshelf.controller;


import com.technaxis.Bookshelf.controller.dto.*;
import com.technaxis.Bookshelf.model.Book;
import com.technaxis.Bookshelf.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("books")
public class BookController {

    @Autowired
    private BookService bookService;


    @GetMapping(value = "{id}")
    public ResponseEntity<BookResponseDto> getBook(@PathVariable("id") Long bookId) {
        if (bookId == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Book book = bookService.getById(bookId);
        if (book == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        //Конвертируем сущность в дто
        BookResponseDto dto = new BookResponseDto();
        dto.setAuthor(book.getAuthor())
                .setId(book.getBookId())
                .setDescription(book.getDescription())
                .setIsbn(book.getIsbn())
                .setPrintYear(book.getPrintYear())
                .setReadAlready(book.isReadAlready())
                .setTitle(book.getTitle())
                .setImage(book.getImage());

        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Book> saveBook(@RequestBody @Valid BookSaveDto bookDto) {
        if (bookDto == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        //Конвертируем дто в сущность
        Book book = new Book();
        book.setAuthor(bookDto.getAuthor());
        book.setDescription(bookDto.getDescription());
        book.setIsbn(bookDto.getIsbn());
        book.setPrintYear(bookDto.getPrintYear());
        book.setTitle(bookDto.getTitle());
        book.setReadAlready(false);
        book.setImage(bookDto.getImage());

        bookService.save(book);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping(value = "{id}")
    public ResponseEntity<Book> updateBook(@RequestBody @Valid BookUpdateDto bookDto, @PathVariable Long id) {
        if (bookDto == null || id == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Book book = bookService.getById(id);
        if (book == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        //Если книга еще не прочитана и нам пришел флаг что книгу прочитали то меняем только факт чтения
        //иначе обновляем сущность по пришедшим в дто данным
        if (!book.isReadAlready() && bookDto.getReadAlready() != null && bookDto.getReadAlready()) {
            book.setReadAlready(true);
        } else {
            book.setTitle(bookDto.getTitle())
                    .setIsbn(bookDto.getIsbn())
                    .setPrintYear(bookDto.getPrintYear())
                    .setDescription(bookDto.getDescription())
                    .setImage(bookDto.getImage())
                    .setReadAlready(false);
        }

        bookService.save(book);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<Book> deleteBook(@PathVariable Long id) {
        Book book = bookService.getById(id);

        if (book == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        bookService.delete(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/all")
    public ResponseEntity<BookPaginationResponseDto> getAllBooks(@RequestBody BookPaginationDto requestDto) {
        Page<Book> books = this.bookService.getAll(requestDto);

        if (books.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        BookPaginationResponseDto paginationResponseDto = new BookPaginationResponseDto();
        paginationResponseDto.setContent(new ArrayList<>());

        for (Book book : books.getContent()) {
            BookResponseDto dto = new BookResponseDto();
            dto.setAuthor(book.getAuthor())
                    .setId(book.getBookId())
                    .setDescription(book.getDescription())
                    .setIsbn(book.getIsbn())
                    .setPrintYear(book.getPrintYear())
                    .setReadAlready(book.isReadAlready())
                    .setTitle(book.getTitle())
                    .setImage(book.getImage());
            paginationResponseDto.getContent().add(dto);
        }

        paginationResponseDto.setPages(books.getTotalPages());

        return new ResponseEntity<>(paginationResponseDto, HttpStatus.OK);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }

}



