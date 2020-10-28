package com.referenceit.otherprintsource.marketreport;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class MarketReportService {


    private MarketReportMapper marketReportMapper;


    public MarketReportResponse generateReference(MarketReportDto marketReportDto) {
        MarketReport marketReport = marketReportMapper.fromDto(marketReportDto);

        return createReference(marketReport);
    }

    private MarketReportResponse createReference(MarketReport marketReport) {
        MarketReportResponse marketReportResponse = new MarketReportResponse();

        String nameOfIssuingBodyAndYearPart = appendIssuingBodyAndYearPart(marketReport);
        marketReportResponse.setNameOfIssuingBodyAndYearPart(nameOfIssuingBodyAndYearPart);

        String titleAndYearPart = appendTitleAndDatePart(marketReport);
        marketReportResponse.setTitleAndDatePart(titleAndYearPart);

        String publicationPlaceAndPublisherPart = appendPublicationPlaceAndPublisher(marketReport);
        marketReportResponse.setRestReferenceBodyPart(publicationPlaceAndPublisherPart);

        return marketReportResponse;
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
