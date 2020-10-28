package com.referenceit.otherprintsource.marketreport;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MarketReportDto {

    private String year;
    private String publicationPlace;
    private String publisher;
    private String title;
    private String date;
    private String nameOfIssuingBody;
    private String reportNumber;
    private String edition;
}
