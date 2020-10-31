package com.referenceit.onlinesource.financialreport;

import com.referenceit.reference.ReferenceResponse;
import com.referenceit.reference.ReferenceService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class FinancialReportService {

    private ReferenceService referenceService;
    private FinancialReportMapper financialReportMapper;


    public ReferenceResponse generateReference(FinancialReportDto financialReportDto) {
        FinancialReport financialReport = financialReportMapper.fromDto(financialReportDto);

        return createReference(financialReport);
    }

    private ReferenceResponse createReference(FinancialReport financialReport) {
        ReferenceResponse referenceResponse = new ReferenceResponse();

        String author = referenceService.remakeAndAppendMultipleAuthors(financialReport.getAuthors());
        String year = appendYear(financialReport);
        referenceResponse.setFirstPartNormal(author + year);

        referenceResponse.setItalicsPart(financialReport.getTitle() + ". [Online] ");

        String availableFrom = "Available from: " + financialReport.getAvailableFrom();
        String accessedDate = " [Accessed " + financialReport.getAccessedDate() + "].";
        referenceResponse.setThirdPartNormal(availableFrom + accessedDate);

        return referenceResponse;
    }

    private String appendYear(FinancialReport financialReport) {
        return " (" + financialReport.getYear() + ") ";
    }

}
