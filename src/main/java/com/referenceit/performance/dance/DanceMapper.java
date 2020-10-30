package com.referenceit.performance.dance;

import org.springframework.stereotype.Component;

@Component
public class DanceMapper {

    public Dance fromDto(DanceDto danceDto) {
        return Dance.builder()
                .authors(danceDto.getAuthors())
                .year(danceDto.getYear())
                .title(danceDto.getTitle())
                .company(danceDto.getCompany())
                .location(danceDto.getLocation())
                .seenDate(danceDto.getSeenDate())
                .build();
    }

}
