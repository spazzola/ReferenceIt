package com.referenceit.book;

import com.referenceit.reference.Reference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class BookDto extends Reference {

    private String title;
    private String edition;
    private String publicationPlace;
    private String publisher;
    private String chapterTitle;
    private String pages;
    private boolean isWithChapter;

}
