package com.referenceit.otherprintsource.governmentpublication;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class GovernmentPublicationService {

    private GovernmentPublicationMapper governmentPublicationMapper;


    public GovernmentPublicationResponse generateReference(GovernmentPublicationDto governmentPublicationDto) {
        GovernmentPublication governmentPublication = governmentPublicationMapper.fromDto(governmentPublicationDto);

        return createReference(governmentPublication);
    }

    private GovernmentPublicationResponse createReference(GovernmentPublication governmentPublication) {
        GovernmentPublicationResponse governmentPublicationResponse = new GovernmentPublicationResponse();

        String knowBy = standardizeType(governmentPublication);

        if (knowBy.equals("GOVERNMENT")) {
            governmentPublicationResponse = processReferencingKnowByGovernment(governmentPublication, governmentPublicationResponse);
        } else if (knowBy.equals("TITLE") || knowBy.equals("CHAIRMAN")) {
            governmentPublicationResponse = processReferencingKnowByTitleOrChairman(governmentPublication, governmentPublicationResponse);
        }
        return governmentPublicationResponse;
    }

    private GovernmentPublicationResponse processReferencingKnowByGovernment(
            GovernmentPublication governmentPublication, GovernmentPublicationResponse governmentPublicationResponse) {

        String nameOfIssuingBodyPart = appendNameOfIssuingBodyAndYear(governmentPublication);
        governmentPublicationResponse.setNameOfIssuingBodyAndYearPart(nameOfIssuingBodyPart);

        String titlePart = appendTitle(governmentPublication);
        governmentPublicationResponse.setTitlePart(titlePart);

        String publicationPlaceAndPublisherPart = appendPublicationPlaceAndPublisher(governmentPublication);

        if (governmentPublication.getReportNumber() != null) {
            publicationPlaceAndPublisherPart += ", ";
            governmentPublicationResponse.setPublicationPlaceAndPublisherPart(publicationPlaceAndPublisherPart);

            String reportNumberPart = appendReportNumber(governmentPublication);
            governmentPublicationResponse.setReportNumberPart(reportNumberPart);
        }
        else {
            publicationPlaceAndPublisherPart += ".";
            governmentPublicationResponse.setPublicationPlaceAndPublisherPart(publicationPlaceAndPublisherPart);
            governmentPublicationResponse.setReportNumberPart("");
        }
        return governmentPublicationResponse;
    }

    private GovernmentPublicationResponse processReferencingKnowByTitleOrChairman(
            GovernmentPublication governmentPublication, GovernmentPublicationResponse governmentPublicationResponse) {

        String nameOfKnowByPart = appendNameOfKnowBy(governmentPublication);
        governmentPublicationResponse.setNameOfKnowByPart(nameOfKnowByPart);

        String nameOfIssuingBodyPart = appendNameOfIssuingBodyAndYear(governmentPublication);
        governmentPublicationResponse.setNameOfIssuingBodyAndYearPart(nameOfIssuingBodyPart + ".");

        return governmentPublicationResponse;
    }

    private String standardizeType(GovernmentPublication governmentPublication) {
        return governmentPublication.getKnowBy().toUpperCase();
    }

    private String appendNameOfIssuingBodyAndYear(GovernmentPublication governmentPublication) {
        return governmentPublication.getNameOfIssuingBody().toUpperCase() + appendYear(governmentPublication);
    }

    private String appendYear(GovernmentPublication governmentPublication) {
        return " (" + governmentPublication.getYear() + ")";
    }

    private String appendTitle(GovernmentPublication governmentPublication) {
        return " " + governmentPublication.getTitle() + ". ";
    }

    private String appendPublicationPlaceAndPublisher(GovernmentPublication governmentPublication) {
        return governmentPublication.getPublicationPlace() + ": " + governmentPublication.getPublisher();
    }

    private String appendReportNumber(GovernmentPublication governmentPublication) {
        return governmentPublication.getReportNumber() + ".";
    }

    private String appendNameOfKnowBy(GovernmentPublication governmentPublication) {
        return governmentPublication.getNameOfKnowBy() + " - see ";
    }
}
