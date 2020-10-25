package com.referenceit.otherprintsource.governmentpublication;

import org.springframework.stereotype.Component;

@Component
public class GovernmentPublicationMapper {

    public GovernmentPublication fromDto(GovernmentPublicationDto governmentPublicationDto) {
        return GovernmentPublication.builder()
                .knowBy(governmentPublicationDto.getKnowBy())
                .year(governmentPublicationDto.getYear())
                .publicationPlace(governmentPublicationDto.getPublicationPlace())
                .publisher(governmentPublicationDto.getPublisher())
                .title(governmentPublicationDto.getTitle())
                .nameOfIssuingBody(governmentPublicationDto.getNameOfIssuingBody())
                .reportNumber(governmentPublicationDto.getReportNumber())
                .nameOfKnowBy(governmentPublicationDto.getNameOfKnowBy())
                .build();
    }

}
