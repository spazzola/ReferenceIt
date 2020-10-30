package com.referenceit.onlinesource.financialreport;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class FinancialReportResponse {

    private String authorAndYearPart;
    private String titlePart;
    private String restReferenceBodyPart;

}
