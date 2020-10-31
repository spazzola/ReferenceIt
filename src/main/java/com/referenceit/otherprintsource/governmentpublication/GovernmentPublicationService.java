package com.referenceit.otherprintsource.governmentpublication;

import com.referenceit.reference.ReferenceResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class GovernmentPublicationService {

    private GovernmentPublicationMapper governmentPublicationMapper;


    public ReferenceResponse generateReference(GovernmentPublicationDto governmentPublicationDto) {
        GovernmentPublication governmentPublication = governmentPublicationMapper.fromDto(governmentPublicationDto);

        return createReference(governmentPublication);
    }

    private ReferenceResponse createReference(GovernmentPublication governmentPublication) {
        ReferenceResponse referenceResponse = new ReferenceResponse();

        String knowBy = standardizeType(governmentPublication);

        if (knowBy.equals("GOVERNMENT"))
            referenceResponse = processReferencingKnowByGovernment(governmentPublication, referenceResponse);
        else if (knowBy.equals("TITLE") || knowBy.equals("CHAIRMAN")) {
            referenceResponse = processReferencingKnowByTitleOrChairman(governmentPublication, referenceResponse);
        }
        return referenceResponse;
    }

    private ReferenceResponse processReferencingKnowByGovernment(
            GovernmentPublication governmentPublication, ReferenceResponse referenceResponse) {

        String nameOfIssuingBodyPart = appendNameOfIssuingBodyAndYear(governmentPublication);
        referenceResponse.setFirstPartNormal(nameOfIssuingBodyPart);

        String titlePart = appendTitle(governmentPublication);
        referenceResponse.setItalicsPart(titlePart);

        String publicationPlaceAndPublisherPart = appendPublicationPlaceAndPublisher(governmentPublication);

        if (governmentPublication.getReportNumber() != null) {
            publicationPlaceAndPublisherPart += ", ";
            String reportNumberPart = appendReportNumber(governmentPublication);
            referenceResponse.setThirdPartNormal(publicationPlaceAndPublisherPart + reportNumberPart);
        }
        else {
            publicationPlaceAndPublisherPart += ".";
            referenceResponse.setThirdPartNormal(publicationPlaceAndPublisherPart);
            //referenceResponse.setReportNumberPart("");
        }
        return referenceResponse;
    }

    private ReferenceResponse processReferencingKnowByTitleOrChairman(
            GovernmentPublication governmentPublication, ReferenceResponse referenceResponse) {

        String nameOfKnowByPart = appendNameOfKnowBy(governmentPublication);
        String nameOfIssuingBodyPart = appendNameOfIssuingBodyAndYear(governmentPublication);
        referenceResponse.setThirdPartNormal(nameOfKnowByPart + nameOfIssuingBodyPart + ".");

        return referenceResponse;
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
