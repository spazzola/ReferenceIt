package com.referenceit.onlinesource.socialmedia;

import org.springframework.stereotype.Component;

@Component
public class SocialMediaMapper {

    public SocialMedia fromDto(SocialMediaDto socialMediaDto) {
        return SocialMedia.builder()
                .authors(socialMediaDto.getAuthors())
                .year(socialMediaDto.getYear())
                .title(socialMediaDto.getTitle())
                .websiteTitle(socialMediaDto.getWebsiteTitle())
                .dayAndMonth(socialMediaDto.getDayAndMonth())
                .availableFrom(socialMediaDto.getAvailableFrom())
                .accessedDate(socialMediaDto.getAccessedDate())
                .build();
    }

}
