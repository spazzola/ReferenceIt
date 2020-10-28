package com.referenceit.otherprintsource.musicscore;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MusicScoreResponse {

    private String composerAndYearPart;
    private String titlePart;
    private String publisherAndPublicationPlacePart;

}
