package com.referenceit.otherprintsource.britishstandard;

import org.springframework.stereotype.Component;

@Component
public class BritishStandardMapper {

    public BritishStandard fromDto(BritishStandardDto britishStandardDto) {
        return BritishStandard.builder()
                .authorisingOrganisationName(britishStandardDto.getAuthorisingOrganisationName())
                .year(britishStandardDto.getYear())
                .titleOfStandard(britishStandardDto.getTitleOfStandard())
                .publicationPlace(britishStandardDto.getPublicationPlace())
                .publisher(britishStandardDto.getPublisher())
                .build();
    }
}
