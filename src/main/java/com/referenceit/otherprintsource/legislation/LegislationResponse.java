package com.referenceit.otherprintsource.legislation;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LegislationResponse {

    private String titleAndYearPart;
    private String chapterPart;
    private String siOrYearNumber;
    private String publisherAndPublicationPlacePart;

}
