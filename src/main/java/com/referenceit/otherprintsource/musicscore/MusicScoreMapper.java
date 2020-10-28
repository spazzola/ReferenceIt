package com.referenceit.otherprintsource.musicscore;

import org.springframework.stereotype.Component;

@Component
public class MusicScoreMapper {


    public MusicScore fromDto(MusicScoreDto musicScoreDto) {
        return MusicScore.builder()
                .authors(musicScoreDto.getAuthors())
                .year(musicScoreDto.getYear())
                .title(musicScoreDto.getTitle())
                .publicationPlace(musicScoreDto.getPublicationPlace())
                .publisher(musicScoreDto.getPublisher())
                .build();
    }

}
