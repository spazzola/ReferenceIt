package com.referenceit.otherprintsource.exhibition;

import org.springframework.stereotype.Component;

@Component
public class ExhibitionMapper {

    public Exhibition fromDto(ExhibitionDto exhibitionDto) {
        return Exhibition.builder()
                .authors(exhibitionDto.getAuthors())
                .year(exhibitionDto.getYear())
                .publicationPlace(exhibitionDto.getPublicationPlace())
                .publisher(exhibitionDto.getPublisher())
                .location(exhibitionDto.getLocation())
                .date(exhibitionDto.getDate())
                .exhibitionCatalogue(exhibitionDto.getExhibitionCatalogue())
                .itemType(exhibitionDto.getItemType())
                .title(exhibitionDto.getTitle())
                .isItemFromExhibition(exhibitionDto.isItemFromExhibition())
                .build();
    }

}
