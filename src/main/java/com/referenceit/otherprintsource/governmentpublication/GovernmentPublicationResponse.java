package com.referenceit.otherprintsource.governmentpublication;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class GovernmentPublicationResponse {

    private String publicationPlaceAndPublisherPart;
    private String titlePart;
    private String nameOfIssuingBodyAndYearPart;
    private String reportNumberPart;
    private String nameOfKnowByPart;

}
