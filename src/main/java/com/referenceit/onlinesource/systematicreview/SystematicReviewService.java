package com.referenceit.onlinesource.systematicreview;

import com.referenceit.reference.ReferenceResponse;
import com.referenceit.reference.ReferenceService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class SystematicReviewService {

    private ReferenceService referenceService;
    private SystematicReviewMapper systematicReviewMapper;


    public ReferenceResponse generateReference(SystematicReviewDto systematicReviewDto) {
        SystematicReview systematicReview = systematicReviewMapper.fromDto(systematicReviewDto);

        return createReference(systematicReview);
    }

    private ReferenceResponse createReference(SystematicReview systematicReview) {
        ReferenceResponse referenceResponse = new ReferenceResponse();

        String author = referenceService.remakeAndAppendMultipleAuthors(systematicReview.getAuthors());
        String year = appendYear(systematicReview);
        String reviewTitle = appendReviewTitle(systematicReview);
        String additionalPart = "[Systematic review] ";
        referenceResponse.setFirstPartNormal(author + year + reviewTitle + additionalPart);

        referenceResponse.setItalicsPart(systematicReview.getSourceTitle() + ", ");

        String issueNumber = appendIssueNumber(systematicReview);
        String accessedDate = appendAccessedDate(systematicReview);
        referenceResponse.setThirdPartNormal(issueNumber + accessedDate);

        return referenceResponse;
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
