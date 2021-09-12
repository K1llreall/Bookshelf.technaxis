package com.technaxis.Bookshelf.model;


import javax.persistence.*;

@Entity
@Table(name= "books")
public class Book extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id", nullable = false)
    private Long bookId;

    @Column(name="title", length = 100)
    private String title;

    @Column(name="description")
    private String description;

    @Column(name= "author", updatable = false)
    private String author;

    @Column(name= "isbn", length = 20)
    private String isbn;

    @Column(name= "print_year")
    private Integer printYear;

    @Column(name= "read_already")
    private Boolean readAlready;

    @Column(name= "image")
    private String image;

    @PrePersist
    private void init() {
        if(readAlready == null) {
            this.setReadAlready(false);
        }
    }

    public Long getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public Book setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Book setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getAuthor() {
        return author;
    }

    public Book setAuthor(String author) {
        this.author = author;
        return this;
    }

    public String getIsbn() {
        return isbn;
    }

    public Book setIsbn(String isbn) {
        this.isbn = isbn;
        return this;
    }

    public Integer getPrintYear() {
        return printYear;
    }

    public Book setPrintYear(Integer printYear) {
        this.printYear = printYear;
        return this;
    }

    public Boolean isReadAlready() {
        return readAlready;
    }

    public Book setReadAlready(Boolean readAlready) {
        this.readAlready = readAlready;
        return this;
    }

    public String getImage() {
        return image;
    }

    public Book setImage(String image) {
        this.image = image;
        return this;
    }
}
