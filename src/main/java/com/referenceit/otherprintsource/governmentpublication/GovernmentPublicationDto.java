package com.referenceit.otherprintsource.governmentpublication;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GovernmentPublicationDto {

    private String knowBy;
    private String nameOfKnowBy;
    private String year;
    private String publicationPlace;
    private String publisher;
    private String title;
    private String nameOfIssuingBody;
    private String reportNumber;


}
