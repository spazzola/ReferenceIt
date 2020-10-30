package com.referenceit.onlinesource.wiki;

import org.springframework.stereotype.Component;

@Component
public class WikiMapper {

    public Wiki fromDto(WikiDto wikiDto) {
        return Wiki.builder()
                .authors(wikiDto.getAuthors())
                .year(wikiDto.getYear())
                .title(wikiDto.getTitle())
                .availableFrom(wikiDto.getAvailableFrom())
                .accessedDate(wikiDto.getAccessedDate())
                .build();
    }

}
