package com.referenceit.onlinesource.wiki;

import com.referenceit.reference.ReferenceService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class WikiService {

    private ReferenceService referenceService;
    private WikiMapper wikiMapper;


    public WikiResponse generateReference(WikiDto wikiDto) {
        Wiki wiki = wikiMapper.fromDto(wikiDto);

        return createReference(wiki);
    }

    public WikiResponse createReference(Wiki wiki) {
        WikiResponse wikiResponse = new WikiResponse();

        String author = referenceService.remakeAndAppendMultipleAuthors(wiki.getAuthors());
        String year = appendYear(wiki);
        wikiResponse.setAuthorAndYearPart(author + year);

        String title = appendTitle(wiki);
        wikiResponse.setTitle(title);

        String availableFrom = appendAvailableFrom(wiki);
        String accessedDate = appendAccessedDate(wiki);
        wikiResponse.setRestReferenceBodyPart(availableFrom + accessedDate);

        return wikiResponse;
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
