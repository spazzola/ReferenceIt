package com.referenceit.otherprintsource.dictionaryencyclopaedia;

import org.springframework.stereotype.Component;

@Component
public class DictAndEncyMapper {

    public DictAndEncy fromDto(DictAndEncyDto dictAndEncyDto) {
        return DictAndEncy.builder()
                .authors(dictAndEncyDto.getAuthors())
                .editors(dictAndEncyDto.getEditors())
                .volumeNumber(dictAndEncyDto.getVolumeNumber())
                .year(dictAndEncyDto.getYear())
                .title(dictAndEncyDto.getTitle())
                .edition(dictAndEncyDto.getEdition())
                .publicationPlace(dictAndEncyDto.getPublicationPlace())
                .publisher(dictAndEncyDto.getPublisher())
                .chapterTitle(dictAndEncyDto.getChapterTitle())
                .pages(dictAndEncyDto.getPages())
                .build();
    }

}
