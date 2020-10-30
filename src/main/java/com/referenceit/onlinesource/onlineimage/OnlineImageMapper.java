package com.referenceit.onlinesource.onlineimage;

import org.springframework.stereotype.Component;

@Component
public class OnlineImageMapper {

    public OnlineImage fromDto(OnlineImageDto onlineImageDto) {
        return OnlineImage.builder()
                .authors(onlineImageDto.getAuthors())
                .title(onlineImageDto.getTitle())
                .year(onlineImageDto.getYear())
                .availableFrom(onlineImageDto.getAvailableFrom())
                .accessedDate(onlineImageDto.getAccessedDate())
                .build();
    }

}
