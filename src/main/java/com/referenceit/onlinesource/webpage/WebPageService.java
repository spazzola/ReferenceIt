package com.referenceit.onlinesource.webpage;

import com.referenceit.reference.ReferenceResponse;
import com.referenceit.reference.ReferenceService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class WebPageService {

    private ReferenceService referenceService;
    private WebPageMapper webPageMapper;


    public ReferenceResponse generateReference(WebPageDto webPageDto) {
        WebPage webPage = webPageMapper.fromDto(webPageDto);

        return createReference(webPage);
    }

    private ReferenceResponse createReference(WebPage webPage) {
        ReferenceResponse referenceResponse = new ReferenceResponse();

        String author = referenceService.remakeAndAppendMultipleAuthors(webPage.getAuthors());
        String year = appendYear(webPage);
        referenceResponse.setFirstPartNormal(author + year);

        String title = appendTitle(webPage);
        referenceResponse.setItalicsPart(title);

        String additionalPart = " [Online] ";
        String responsibleOrganisation = appendResponsibleOrganisation(webPage);
        String availableFrom = "Available from: " + webPage.getAvailableFrom();
        String accessedDate = " [Accessed " + webPage.getAccessedDate() + "].";
        referenceResponse.setThirdPartNormal(additionalPart + responsibleOrganisation + availableFrom + accessedDate);

        return referenceResponse;
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
