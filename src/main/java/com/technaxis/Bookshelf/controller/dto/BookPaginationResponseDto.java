package com.technaxis.Bookshelf.controller.dto;

import java.util.List;

public class BookPaginationResponseDto {
    private List<BookResponseDto> content;
    private int pages;

    public List<BookResponseDto> getContent() {
        return content;
    }

    public BookPaginationResponseDto setContent(List<BookResponseDto> content) {
        this.content = content;
        return this;
    }

    public int getPages() {
        return pages;
    }

    public BookPaginationResponseDto setPages(int pages) {
        this.pages = pages;
        return this;
    }
}
