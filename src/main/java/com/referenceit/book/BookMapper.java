package com.referenceit.book;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BookMapper {

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
