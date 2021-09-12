package com.technaxis.Bookshelf.model;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.File;

@Entity
@Table(name= "books")
@Getter
@Setter
@ToString
public class Book extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id", nullable = false)
    private Long bookId;

    @Column(name="title")
    private String title;

    @Column(name="description")
    private String description;

    @Column(name= "author")
    private String author;

    @Column(name= "isbn")
    private String isbn;

    @Column(name= "print_year")
    private int printYear;

    @Column(name= "read_already")
    private boolean readAlready;

    @Column(name= "image")
    private File image;
}
