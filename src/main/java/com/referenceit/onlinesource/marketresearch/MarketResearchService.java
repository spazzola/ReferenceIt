package com.referenceit.onlinesource.marketresearch;

import com.referenceit.reference.ReferenceService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class MarketResearchService {

    private ReferenceService referenceService;
    private MarketResearchMapper marketResearchMapper;


    public MarketResearchResponse generateReference(MarketResearchDto marketResearchDto) {
        MarketResearch marketResearch = marketResearchMapper.fromDto(marketResearchDto);

        return createReference(marketResearch);
    }

    private MarketResearchResponse createReference(MarketResearch marketResearch) {
        MarketResearchResponse marketResearchResponse = new MarketResearchResponse();

        String author = referenceService.remakeAndAppendMultipleAuthors(marketResearch.getAuthors());
        String year = appendYear(marketResearch);
        marketResearchResponse.setAuthorAndYearPart(author + year);

        String title = marketResearch.getTitle();
        String date = appendDateIfExist(marketResearch);
        marketResearchResponse.setTitleAndDatePart(title + date);

        String edition = appendEditionIfExist(marketResearch);
        String availableFrom = "[Online] Available from: " + marketResearch.getAvailableFrom();
        String accessedDate = " [Accessed " + marketResearch.getAccessedDate() + "].";
        marketResearchResponse.setRestReferenceBodyPart(edition + availableFrom + accessedDate);

        return marketResearchResponse;
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
