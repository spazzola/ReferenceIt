package com.referenceit.otherprintsource.exhibition;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ExhibitionResponse {

    private String artistAndYearPart;
    private String titlePart;
    private String exhibitionCataloguePlacesAndPublisherPart;
    private String itemTypeLocationAndDate;

}
