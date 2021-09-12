package com.technaxis.Bookshelf.controller.dto;

public class BookResponseDto {
    private Long id;
    private String title;
    private String description;
    private String author;
    private String isbn;
    private boolean readAlready;
    private String image;
    private int printYear;

    public String getTitle() {
        return title;
    }

    public BookResponseDto setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public BookResponseDto setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getAuthor() {
        return author;
    }

    public BookResponseDto setAuthor(String author) {
        this.author = author;
        return this;
    }

    public String getIsbn() {
        return isbn;
    }

    public BookResponseDto setIsbn(String isbn) {
        this.isbn = isbn;
        return this;
    }

    public int getPrintYear() {
        return printYear;
    }

    public BookResponseDto setPrintYear(int printYear) {
        this.printYear = printYear;
        return this;
    }

    public Long getId() {
        return id;
    }

    public BookResponseDto setId(Long id) {
        this.id = id;
        return this;
    }

    public boolean isReadAlready() {
        return readAlready;
    }

    public BookResponseDto setReadAlready(boolean readAlready) {
        this.readAlready = readAlready;
        return this;
    }

    public String getImage() {
        return image;
    }

    public BookResponseDto setImage(String image) {
        this.image = image;
        return this;
    }
}
