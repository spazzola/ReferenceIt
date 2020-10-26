package com.referenceit.otherprintsource.legislation;

import org.springframework.stereotype.Component;

@Component
public class LegislationMapper {

    public Legislation fromDto(LegislationDto legislationDto) {
        return Legislation.builder()
                .year(legislationDto.getYear())
                .title(legislationDto.getTitle())
                .chapterNumber(legislationDto.getChapterNumber())
                .publicationPlace(legislationDto.getPublicationPlace())
                .publisher(legislationDto.getPublisher())
                .siYearNumber(legislationDto.getSiYearNumber())
                .isParliamentAct(legislationDto.isParliamentAct())
                .build();
    }

}
