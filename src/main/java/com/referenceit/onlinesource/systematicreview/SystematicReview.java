package com.referenceit.onlinesource.systematicreview;

import com.referenceit.otherprintsource.OtherPrintSource;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@AllArgsConstructor
public class SystematicReview extends OtherPrintSource {

    private String reviewTitle;
    private String sourceTitle;
    private String issueNumber;
    private String accessedDate;

}
