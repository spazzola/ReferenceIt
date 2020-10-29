package com.referenceit.otherprintsource.theseanddissertation;

import org.springframework.stereotype.Component;

@Component
public class TheseAndDissertationMapper {

    public TheseAndDissertation fromDto(TheseAndDissertationDto theseAndDissertationDto) {
        return TheseAndDissertation.builder()
                .authors(theseAndDissertationDto.getAuthors())
                .year(theseAndDissertationDto.getYear())
                .title(theseAndDissertationDto.getTitle())
                .designation(theseAndDissertationDto.getDesignation())
                .degreeLevel(theseAndDissertationDto.getDegreeLevel())
                .institution(theseAndDissertationDto.getInstitution())
                .build();
    }

}
