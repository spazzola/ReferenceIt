package com.referenceit.otherprintsource.marketreport;

import com.referenceit.otherprintsource.OtherPrintSource;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@AllArgsConstructor
public class MarketReport extends OtherPrintSource {

    private String date;
    private String nameOfIssuingBody;
    private String reportNumber;
    private String edition;

}
