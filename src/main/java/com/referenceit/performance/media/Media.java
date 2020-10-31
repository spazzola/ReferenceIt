package com.referenceit.performance.media;

import com.referenceit.otherprintsource.OtherPrintSource;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
public class Media extends OtherPrintSource {

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
