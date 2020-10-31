package com.referenceit.otherprintsource.marketreport;

import com.referenceit.reference.ReferenceResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class MarketReportService {


    private MarketReportMapper marketReportMapper;


    public ReferenceResponse generateReference(MarketReportDto marketReportDto) {
        MarketReport marketReport = marketReportMapper.fromDto(marketReportDto);

        return createReference(marketReport);
    }

    private ReferenceResponse createReference(MarketReport marketReport) {
        ReferenceResponse referenceResponse = new ReferenceResponse();

        String nameOfIssuingBodyAndYearPart = appendIssuingBodyAndYearPart(marketReport);
        referenceResponse.setFirstPartNormal(nameOfIssuingBodyAndYearPart);

        String titleAndYearPart = appendTitleAndDatePart(marketReport);
        referenceResponse.setItalicsPart(titleAndYearPart);

        String publicationPlaceAndPublisherPart = appendPublicationPlaceAndPublisher(marketReport);
        referenceResponse.setThirdPartNormal(publicationPlaceAndPublisherPart);

        return referenceResponse;
    }

    private String appendIssuingBodyAndYearPart(MarketReport marketReport) {
        return marketReport.getNameOfIssuingBody().toUpperCase() + " (" + marketReport.getYear() + ") ";
    }

    private String appendTitleAndDatePart(MarketReport marketReport) {
        return marketReport.getTitle() + ", " + marketReport.getDate() + ". ";
    }

    private String appendPublicationPlaceAndPublisher(MarketReport marketReport) {
        return marketReport.getPublicationPlace() + ": " + marketReport.getPublisher() + ".";
    }

}
