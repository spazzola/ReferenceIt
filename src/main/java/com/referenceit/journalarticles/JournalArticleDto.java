package com.referenceit.journalarticles;

import com.referenceit.reference.Reference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class JournalArticleDto extends Reference {

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

}
