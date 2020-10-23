package com.referenceit.otherprintsource.britishstandard;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BritishStandardResponse {

    private String authorisingOrganisationNamePart;
    private String yearPart;
    private String titleOfStandardPart;
    private String publisherAndPublicationPlacePart;

}
