package com.technaxis.Bookshelf.controller.dto;

import javax.validation.constraints.Size;

public class BookSaveDto {
    @Size(max = 100)
    private String title;
    private String description;
    @Size(max = 100)
    private String author;
    @Size(max = 20)
    private String isbn;
    private int printYear;
    private String image;

    public String getTitle() {
        return title;
    }

    public BookSaveDto setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public BookSaveDto setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getAuthor() {
        return author;
    }

    public BookSaveDto setAuthor(String author) {
        this.author = author;
        return this;
    }

    public String getIsbn() {
        return isbn;
    }

    public BookSaveDto setIsbn(String isbn) {
        this.isbn = isbn;
        return this;
    }

    public int getPrintYear() {
        return printYear;
    }

    public BookSaveDto setPrintYear(int printYear) {
        this.printYear = printYear;
        return this;
    }

    public String getImage() {
        return image;
    }

    public BookSaveDto setImage(String image) {
        this.image = image;
        return this;
    }
}
