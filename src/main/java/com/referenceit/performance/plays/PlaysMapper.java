package com.referenceit.performance.plays;

import org.springframework.stereotype.Component;

@Component
public class PlaysMapper {

    public Plays fromDto(PlaysDto playsDto) {
        return Plays.builder()
                .title(playsDto.getTitle())
                .authors(playsDto.getAuthors())
                .year(playsDto.getYear())
                .directorName(playsDto.getDirectorName())
                .companyName(playsDto.getCompanyName())
                .location(playsDto.getLocation())
                .seenDate(playsDto.getSeenDate())
                .build();
    }

}
