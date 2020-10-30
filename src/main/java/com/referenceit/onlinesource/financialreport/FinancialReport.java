package com.referenceit.onlinesource.financialreport;

import com.referenceit.otherprintsource.OtherPrintSource;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@AllArgsConstructor
public class FinancialReport extends OtherPrintSource {

    private String availableFrom;
    private String accessedDate;

}
