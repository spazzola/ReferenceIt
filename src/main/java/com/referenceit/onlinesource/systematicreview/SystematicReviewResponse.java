package com.referenceit.onlinesource.systematicreview;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SystematicReviewResponse {

    private String authorYearAndReviewTitlePart;
    private String sourceTitlePart;
    private String issueAndDatePart;

}
