package com.referenceit.onlinesource.systematicreview;

import org.springframework.stereotype.Component;

@Component
public class SystematicReviewMapper {

    public SystematicReview fromDto(SystematicReviewDto systematicReviewDto) {
        return SystematicReview.builder()
                .authors(systematicReviewDto.getAuthors())
                .year(systematicReviewDto.getYear())
                .reviewTitle(systematicReviewDto.getReviewTitle())
                .sourceTitle(systematicReviewDto.getSourceTitle())
                .issueNumber(systematicReviewDto.getIssueNumber())
                .accessedDate(systematicReviewDto.getAccessedDate())
                .build();
    }

}
