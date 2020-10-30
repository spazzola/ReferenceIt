package com.referenceit.onlinesource.marketresearch;

import org.springframework.stereotype.Component;

@Component
public class MarketResearchMapper {

    public MarketResearch fromDto(MarketResearchDto marketResearchDto) {
        return MarketResearch.builder()
                .authors(marketResearchDto.getAuthors())
                .year(marketResearchDto.getYear())
                .date(marketResearchDto.getDate())
                .title(marketResearchDto.getTitle())
                .edition(marketResearchDto.getEdition())
                .availableFrom(marketResearchDto.getAvailableFrom())
                .accessedDate(marketResearchDto.getAccessedDate())
                .build();
    }

}
