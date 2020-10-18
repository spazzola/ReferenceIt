package com.referenceit.journalarticles;

import com.referenceit.reference.Author;
import com.referenceit.reference.Reference;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Data
@SuperBuilder
@NoArgsConstructor
public class JournalArticle extends Reference {

    private String articleTitle;
    private String journalTitle;
    private String volNumber;
    private String partNumber;
    private String issue;
    private String month;
    private String pages;
    private String availableFrom;
    private String accessedDate;
    private boolean isNotYetPrinted;
    private boolean isOpenAccessRepo;
    private boolean isOnlyAvailableOnline;

    public JournalArticle(String year, List<Author> authors) {
        setYear(year);
        setAuthors(authors);
    }

}
