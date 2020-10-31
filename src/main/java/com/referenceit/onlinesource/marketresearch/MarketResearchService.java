package com.referenceit.onlinesource.marketresearch;

import com.referenceit.reference.ReferenceResponse;
import com.referenceit.reference.ReferenceService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class MarketResearchService {

    private ReferenceService referenceService;
    private MarketResearchMapper marketResearchMapper;


    public ReferenceResponse generateReference(MarketResearchDto marketResearchDto) {
        MarketResearch marketResearch = marketResearchMapper.fromDto(marketResearchDto);

        return createReference(marketResearch);
    }

    private ReferenceResponse createReference(MarketResearch marketResearch) {
        ReferenceResponse referenceResponse = new ReferenceResponse();

        String author = referenceService.remakeAndAppendMultipleAuthors(marketResearch.getAuthors());
        String year = appendYear(marketResearch);
        referenceResponse.setFirstPartNormal(author + year);

        String title = marketResearch.getTitle();
        String date = appendDateIfExist(marketResearch);
        referenceResponse.setItalicsPart(title + date);

        String edition = appendEditionIfExist(marketResearch);
        String availableFrom = "[Online] Available from: " + marketResearch.getAvailableFrom();
        String accessedDate = " [Accessed " + marketResearch.getAccessedDate() + "].";
        referenceResponse.setThirdPartNormal(edition + availableFrom + accessedDate);

        return referenceResponse;
    }

    private String appendYear(MarketResearch marketResearch) {
        return " (" + marketResearch.getYear() + ") ";
    }

    private String appendDateIfExist(MarketResearch marketResearch) {
        if (marketResearch.getDate() != null) {
            return ", " + marketResearch.getDate() + ". ";
        }
        return ". ";
    }

    private String appendEditionIfExist(MarketResearch marketResearch) {
        if (marketResearch.getEdition() != null) {
            return appendEdition(marketResearch);
        }
        return "";
    }

    private String appendEdition(MarketResearch marketResearch) {
        String resultEdition = "";
        int edition = Integer.valueOf(marketResearch.getEdition());
        if (edition == 2) {
            resultEdition += marketResearch.getEdition() + "nd ed. ";
        } else if (edition == 3) {
            resultEdition += marketResearch.getEdition() + "rd ed. ";
        } else if (edition > 3) {
            resultEdition += marketResearch.getEdition() + "th ed. ";
        }
        return resultEdition;
    }
}
