package com.referenceit.onlinesource.computergame;

import org.springframework.stereotype.Component;

@Component
public class ComputerGameMapper {

    public ComputerGame fromDto(ComputerGameDto computerGameDto) {
        return ComputerGame.builder()
                .authors(computerGameDto.getAuthors())
                .year(computerGameDto.getYear())
                .title(computerGameDto.getTitle())
                .mediumOfItem(computerGameDto.getMediumOfItem())
                .platform(computerGameDto.getPlatform())
                .publicationPlace(computerGameDto.getPublicationPlace())
                .publisher(computerGameDto.getPublisher())
                .build();
    }

}
