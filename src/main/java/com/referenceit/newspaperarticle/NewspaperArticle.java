package com.referenceit.newspaperarticle;

import com.referenceit.reference.Author;
import com.referenceit.reference.Reference;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Data
@SuperBuilder
@NoArgsConstructor
public class NewspaperArticle extends Reference {

    private String articleTitle;
    private String newspaperTitle;
    private String day;
    private String month;
    private String pages;
    private String availableFrom;
    private String accessedDate;
    private boolean isOnlyAvailableOnline;

    public NewspaperArticle(String year, List<Author> authors) {
        setYear(year);
        setAuthors(authors);
    }

}
