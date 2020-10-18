package com.referenceit.book;

import com.referenceit.reference.Author;
import com.referenceit.reference.Reference;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Data
@SuperBuilder
@NoArgsConstructor
public class Book extends Reference {

    private String title;
    private String edition;
    private String publicationPlace;
    private String publisher;
    private String chapterTitle;
    private String pages;
    private boolean isWithChapter;


    public Book(String year, List<Author> authors) {
        setYear(year);
        setAuthors(authors);
    }

}
