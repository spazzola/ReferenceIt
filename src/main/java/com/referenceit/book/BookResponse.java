package com.referenceit.book;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BookResponse {

    private String authorsPart;
    private String editorsPart;
    private String yearPart;
    private String bookTitlePart;
    private String chapterTitlePartWithEditors;
    private String editionPart;
    private String pagesPart;
    private String publisherAndPublicationPlacePart;


    @Override
    public String toString() {
        return getAuthorsPart() + getYearPart() + getBookTitlePart() + getPublisherAndPublicationPlacePart();
    }
}
