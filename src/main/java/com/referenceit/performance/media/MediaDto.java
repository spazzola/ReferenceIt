package com.referenceit.performance.media;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MediaDto {

    private String title;
    private String year;
    private String referenceType;
    private String mediaType;
    private String directorName;
    private String productionPlace;
    private String productionCompany;
    private String episodeNumber;
    private String episodeName;
    private String channel;
    private String broadcastDate;
    private String broadcastTime;

}
