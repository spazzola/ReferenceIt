package com.referenceit.newspaperarticle;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class NewspaperArticleResponse {

    private String authorsPart;
    private String yearPart;
    private String articleTitlePart;
    private String newspaperTitlePart;
    private String onlinePart;
    private String dayAndMonthPart;
    private String pagesPart;
    private String availableFromAndAccessedDatePart;

}
