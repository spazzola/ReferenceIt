package com.referenceit.book;

import java.util.List;
import java.util.stream.Collectors;

public class BookMapper {

    public BookDto toDto(Book book) {
        return BookDto.builder()
                .authors(book.getAuthors())
                .editors(book.getEditors())
                .year(book.getYear())
                .title(book.getTitle())
                .edition(book.getEdition())
                .publicationPlace(book.getPublicationPlace())
                .publisher(book.getPublisher())
                .chapterTitle(book.getChapterTitle())
                .pages(book.getPages())
                .isWithChapter(book.isWithChapter())
                .build();
    }

    public List<BookDto> toDto(List<Book> books) {
        return books.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    public Book fromDto(BookDto bookDto) {
        return Book.builder()
                .authors(bookDto.getAuthors())
                .editors(bookDto.getEditors())
                .year(bookDto.getYear())
                .title(bookDto.getTitle())
                .edition(bookDto.getEdition())
                .publicationPlace(bookDto.getPublicationPlace())
                .publisher(bookDto.getPublisher())
                .chapterTitle(bookDto.getChapterTitle())
                .pages(bookDto.getPages())
                .isWithChapter(bookDto.isWithChapter())
                .build();
    }

    public List<Book> fromDto(List<BookDto> books) {
        return books.stream()
                .map(this::fromDto)
                .collect(Collectors.toList());
    }

}
