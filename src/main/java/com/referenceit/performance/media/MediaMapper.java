package com.referenceit.performance.media;

import org.springframework.stereotype.Component;

@Component
public class MediaMapper {

    public Media fromDto(MediaDto mediaDto) {
        return Media.builder()
                .title(mediaDto.getTitle())
                .year(mediaDto.getYear())
                .referenceType(mediaDto.getReferenceType())
                .mediaType(mediaDto.getMediaType())
                .directorName(mediaDto.getDirectorName())
                .directorName(mediaDto.getDirectorName())
                .productionPlace(mediaDto.getProductionPlace())
                .productionCompany(mediaDto.getProductionCompany())
                .episodeNumber(mediaDto.getEpisodeNumber())
                .episodeName(mediaDto.getEpisodeName())
                .channel(mediaDto.getChannel())
                .broadcastDate(mediaDto.getBroadcastDate())
                .broadcastTime(mediaDto.getBroadcastTime())
                .build();
    }

}
