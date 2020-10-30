package com.referenceit.onlinesource.financialreport;

import com.referenceit.reference.ReferenceService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class FinancialReportService {

    private ReferenceService referenceService;
    private FinancialReportMapper financialReportMapper;


    public FinancialReportResponse generateReference(FinancialReportDto financialReportDto) {
        FinancialReport financialReport = financialReportMapper.fromDto(financialReportDto);

        return createReference(financialReport);
    }

    private FinancialReportResponse createReference(FinancialReport financialReport) {
        FinancialReportResponse financialReportResponse = new FinancialReportResponse();

        String author = referenceService.remakeAndAppendMultipleAuthors(financialReport.getAuthors());
        String year = appendYear(financialReport);
        financialReportResponse.setAuthorAndYearPart(author + year);

        financialReportResponse.setTitlePart(financialReport.getTitle() + ". [Online] ");

        String availableFrom = "Available from: " + financialReport.getAvailableFrom();
        String accessedDate = " [Accessed " + financialReport.getAccessedDate() + "].";
        financialReportResponse.setRestReferenceBodyPart(availableFrom + accessedDate);

        return financialReportResponse;
    }

    private String appendYear(FinancialReport financialReport) {
        return " (" + financialReport.getYear() + ") ";
    }

}
