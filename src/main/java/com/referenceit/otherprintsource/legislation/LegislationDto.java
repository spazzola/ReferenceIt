package com.referenceit.otherprintsource.legislation;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LegislationDto {

    private String year;
    private String title;
    private String chapterNumber;
    private String publicationPlace;
    private String publisher;
    private String siYearNumber;
    private boolean isParliamentAct;

}
