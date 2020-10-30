package com.referenceit.onlinesource.systematicreview;

import com.referenceit.reference.Author;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SystematicReviewDto {

    private List<Author> authors;
    private String year;
    private String reviewTitle;
    private String sourceTitle;
    private String issueNumber;
    private String accessedDate;

}
