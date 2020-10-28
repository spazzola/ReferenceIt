package com.referenceit.otherprintsource.marketreport;

import org.springframework.stereotype.Component;

@Component
public class MarketReportMapper {

    public MarketReport fromDto(MarketReportDto marketReportDto) {
        return MarketReport.builder()
                .year(marketReportDto.getYear())
                .publicationPlace(marketReportDto.getPublicationPlace())
                .publisher(marketReportDto.getPublisher())
                .title(marketReportDto.getTitle())
                .date(marketReportDto.getDate())
                .nameOfIssuingBody(marketReportDto.getNameOfIssuingBody())
                .reportNumber(marketReportDto.getReportNumber())
                .edition(marketReportDto.getEdition())
                .build();
    }

}
