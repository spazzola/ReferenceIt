package com.referenceit.onlinesource.systematicreview;

import com.referenceit.reference.ReferenceService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class SystematicReviewService {

    private ReferenceService referenceService;
    private SystematicReviewMapper systematicReviewMapper;


    public SystematicReviewResponse generateReference(SystematicReviewDto systematicReviewDto) {
        SystematicReview systematicReview = systematicReviewMapper.fromDto(systematicReviewDto);

        return createReference(systematicReview);
    }

    private SystematicReviewResponse createReference(SystematicReview systematicReview) {
        SystematicReviewResponse systematicReviewResponse = new SystematicReviewResponse();

        String author = referenceService.remakeAndAppendMultipleAuthors(systematicReview.getAuthors());
        String year = appendYear(systematicReview);
        String reviewTitle = appendReviewTitle(systematicReview);
        String additionalPart = "[Systematic review] ";
        systematicReviewResponse.setAuthorYearAndReviewTitlePart(author + year + reviewTitle + additionalPart);

        systematicReviewResponse.setSourceTitlePart(systematicReview.getSourceTitle() + ", ");

        String issueNumber = appendIssueNumber(systematicReview);
        String accessedDate = appendAccessedDate(systematicReview);
        systematicReviewResponse.setIssueAndDatePart(issueNumber + accessedDate);

        return systematicReviewResponse;
    }

    private String appendYear(SystematicReview systematicReview) {
        return " (" + systematicReview.getYear() + ") ";
    }

    private String appendReviewTitle(SystematicReview systematicReview) {
        return systematicReview.getReviewTitle() + ". ";
    }

    private String appendIssueNumber(SystematicReview systematicReview) {
        return "Issue " + systematicReview.getIssueNumber() + ". ";
    }

    private String appendAccessedDate(SystematicReview systematicReview) {
        return "[Accessed " + systematicReview.getAccessedDate() + "].";
    }

}
