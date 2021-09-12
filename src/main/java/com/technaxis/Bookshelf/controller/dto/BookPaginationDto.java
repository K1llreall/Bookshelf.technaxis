package com.technaxis.Bookshelf.controller.dto;

public class BookPaginationDto {
    private Integer size;
    private Integer page;
    private String title;

    public int getSize() {
        return size;
    }

    public int getPage() {
        return page;
    }

    public BookPaginationDto setSize(Integer size) {
        this.size = size;
        return this;
    }

    public BookPaginationDto setPage(Integer page) {
        this.page = page;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public BookPaginationDto setTitle(String title) {
        this.title = title;
        return this;
    }
}
