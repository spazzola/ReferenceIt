package com.referenceit.onlinesource.marketresearch;

import com.referenceit.otherprintsource.OtherPrintSource;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@AllArgsConstructor
public class MarketResearch extends OtherPrintSource {

    private String date;
    private String edition;
    private String availableFrom;
    private String accessedDate;

}
