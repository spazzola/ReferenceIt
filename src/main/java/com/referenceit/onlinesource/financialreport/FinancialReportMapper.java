package com.referenceit.onlinesource.financialreport;

import org.springframework.stereotype.Component;

@Component
public class FinancialReportMapper {

    public FinancialReport fromDto(FinancialReportDto financialReportDto) {
        return FinancialReport.builder()
                .authors(financialReportDto.getAuthors())
                .year(financialReportDto.getYear())
                .title(financialReportDto.getTitle())
                .availableFrom(financialReportDto.getAvailableFrom())
                .accessedDate(financialReportDto.getAccessedDate())
                .build();
    }

}
