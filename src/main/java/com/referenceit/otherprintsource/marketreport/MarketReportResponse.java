package com.referenceit.otherprintsource.marketreport;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MarketReportResponse {

    private String nameOfIssuingBodyAndYearPart;
    private String titleAndDatePart;
    private String restReferenceBodyPart;

}
