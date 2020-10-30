package com.referenceit.onlinesource.webpage;

import com.referenceit.reference.ReferenceService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class WebPageService {

    private ReferenceService referenceService;
    private WebPageMapper webPageMapper;


    public WebPageResponse generateReference(WebPageDto webPageDto) {
        WebPage webPage = webPageMapper.fromDto(webPageDto);

        return createReference(webPage);
    }

    private WebPageResponse createReference(WebPage webPage) {
        WebPageResponse webPageResponse = new WebPageResponse();

        String author = referenceService.remakeAndAppendMultipleAuthors(webPage.getAuthors());
        String year = appendYear(webPage);
        webPageResponse.setAuthorAndYearPart(author + year);

        String title = appendTitle(webPage);
        webPageResponse.setTitlePart(title);

        String additionalPart = " [Online] ";
        String responsibleOrganisation = appendResponsibleOrganisation(webPage);
        String availableFrom = "Available from: " + webPage.getAvailableFrom();
        String accessedDate = " [Accessed " + webPage.getAccessedDate() + "].";
        webPageResponse.setRestReferenceBodyPart(additionalPart + responsibleOrganisation + availableFrom + accessedDate);

        return webPageResponse;
    }

    private String appendYear(WebPage webPage) {
        return " (" + webPage.getYear() + ") ";
    }

    private String appendTitle(WebPage webPage) {
        return webPage.getTitle() + ".";
    }

    private String appendResponsibleOrganisation(WebPage webPage) {
        return webPage.getResponsibleOrganisation() + ". ";
    }
}
