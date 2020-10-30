package com.referenceit.onlinesource.onlinefilm;

import org.springframework.stereotype.Component;

@Component
public class OnlineFilmMapper {

    public OnlineFilm fromDto(OnlineFilmDto onlineFilmDto) {
        return OnlineFilm.builder()
                .authors(onlineFilmDto.getAuthors())
                .year(onlineFilmDto.getYear())
                .title(onlineFilmDto.getTitle())
                //.sourceType(onlineFilmDto.getSourceType())
                .availableFrom(onlineFilmDto.getAvailableFrom())
                .accessedDate(onlineFilmDto.getAccessedDate())
                .build();
    }

}
