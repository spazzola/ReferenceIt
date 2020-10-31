package com.referenceit.onlinesource.wiki;

import com.referenceit.reference.ReferenceResponse;
import com.referenceit.reference.ReferenceService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class WikiService {

    private ReferenceService referenceService;
    private WikiMapper wikiMapper;


    public ReferenceResponse generateReference(WikiDto wikiDto) {
        Wiki wiki = wikiMapper.fromDto(wikiDto);

        return createReference(wiki);
    }

    private ReferenceResponse createReference(Wiki wiki) {
        ReferenceResponse referenceResponse = new ReferenceResponse();

        String author = referenceService.remakeAndAppendMultipleAuthors(wiki.getAuthors());
        String year = appendYear(wiki);
        referenceResponse.setFirstPartNormal(author + year);

        String title = appendTitle(wiki);
        referenceResponse.setItalicsPart(title);

        String availableFrom = appendAvailableFrom(wiki);
        String accessedDate = appendAccessedDate(wiki);
        referenceResponse.setThirdPartNormal(availableFrom + accessedDate);

        return referenceResponse;
    }

    private String appendYear(Wiki wiki) {
        return " (" + wiki.getYear() + ") ";
    }

    private String appendTitle(Wiki wiki) {
        return wiki.getTitle() + ". ";
    }

    private String appendAvailableFrom(Wiki wiki) {
        return "[Online] Available from: " + wiki.getAvailableFrom();
    }

    private String appendAccessedDate(Wiki wiki) {
        return " [Accessed " + wiki.getAccessedDate() + "].";
    }

}
