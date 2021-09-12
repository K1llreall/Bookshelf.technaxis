package com.technaxis.Bookshelf.controller.dto;

import javax.validation.constraints.Max;

public class BookUpdateDto {
    @Max(100)
    private String title;
    private String description;
    @Max(20)
    private String isbn;
    private int printYear;
    private String image;
    private Boolean readAlready;

    public String getTitle() {
        return title;
    }

    public BookUpdateDto setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public BookUpdateDto setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getIsbn() {
        return isbn;
    }

    public BookUpdateDto setIsbn(String isbn) {
        this.isbn = isbn;
        return this;
    }

    public int getPrintYear() {
        return printYear;
    }

    public BookUpdateDto setPrintYear(int printYear) {
        this.printYear = printYear;
        return this;
    }

    public String getImage() {
        return image;
    }

    public BookUpdateDto setImage(String image) {
        this.image = image;
        return this;
    }

    public Boolean getReadAlready() {
        return readAlready;
    }

    public BookUpdateDto setReadAlready(Boolean readAlready) {
        this.readAlready = readAlready;
        return this;
    }
}
