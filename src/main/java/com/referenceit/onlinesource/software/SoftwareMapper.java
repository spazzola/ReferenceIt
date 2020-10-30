package com.referenceit.onlinesource.software;

import org.springframework.stereotype.Component;

@Component
public class SoftwareMapper {

    public Software fromDto(SoftwareDto softwareDto) {
        return Software.builder()
                .authors(softwareDto.getAuthors())
                .year(softwareDto.getYear())
                .title(softwareDto.getTitle())
                .version(softwareDto.getVersion())
                .publicationPlace(softwareDto.getPublicationPlace())
                .publisher(softwareDto.getPublisher())
                .build();
    }

}
