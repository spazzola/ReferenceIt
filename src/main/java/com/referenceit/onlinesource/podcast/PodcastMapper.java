package com.referenceit.onlinesource.podcast;

import org.springframework.stereotype.Component;

@Component
public class PodcastMapper {

    public Podcast fromDto(PodcastDto podcastDto) {
        return Podcast.builder()
                .authors(podcastDto.getAuthors())
                .year(podcastDto.getYear())
                .title(podcastDto.getTitle())
                .publisher(podcastDto.getPublisher())
                .dayAndMonth(podcastDto.getDayAndMonth())
                .availableFrom(podcastDto.getAvailableFrom())
                .accessedDate(podcastDto.getAccessedDate())
                .build();
    }

}
