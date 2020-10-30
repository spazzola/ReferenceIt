package com.referenceit.onlinesource.webpage;

import org.springframework.stereotype.Component;

@Component
public class WebPageMapper {

    public WebPage fromDto(WebPageDto webPageDto) {
        return WebPage.builder()
                .authors(webPageDto.getAuthors())
                .year(webPageDto.getYear())
                .title(webPageDto.getTitle())
                .responsibleOrganisation(webPageDto.getResponsibleOrganisation())
                .availableFrom(webPageDto.getAvailableFrom())
                .accessedDate(webPageDto.getAccessedDate())
                .build();
    }

}
