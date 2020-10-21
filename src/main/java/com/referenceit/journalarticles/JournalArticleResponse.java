package com.referenceit.journalarticles;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class JournalArticleResponse {

    private String authorsPart;
    private String yearPart;
    private String articleTitlePart;
    private String journalTitlePart;
    private String onlinePart;
    private String volIssueMonthPart;
    private String pagesPart;
    private String availableFromAndAccessedDatePart;
    private String forthcomingOrPostprintPart;
    private String dotPart;
    private String comaAndSpacePart;

}
