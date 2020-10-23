package com.referenceit.otherprintsource.conferenceproceeding;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ConferenceProceedingResponse {

    private String authorsPart;
    private String yearPart;
    private String titlePart;
    private String titleOfConferenceProceedingsPart;
    private String placeAndDatePart;
    private String publicationPlaceAndPublisherPart;
    private String pages;

}
