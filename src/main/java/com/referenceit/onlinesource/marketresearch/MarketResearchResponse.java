package com.referenceit.onlinesource.marketresearch;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MarketResearchResponse {

    private String authorAndYearPart;
    private String titleAndDatePart;
    private String restReferenceBodyPart;

}
