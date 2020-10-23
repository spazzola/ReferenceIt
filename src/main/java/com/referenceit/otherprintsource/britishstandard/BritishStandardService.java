package com.referenceit.otherprintsource.britishstandard;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class BritishStandardService {

    private BritishStandardMapper britishStandardMapper;

    public BritishStandardResponse generateReference(BritishStandardDto britishStandardDto) {
        BritishStandard britishStandard = britishStandardMapper.fromDto(britishStandardDto);

        return createReference(britishStandard);
    }

    private BritishStandardResponse createReference(BritishStandard britishStandard) {
        BritishStandardResponse britishStandardResponse = new BritishStandardResponse();

        String authorisingOrganisationNamePart = appendAuthorisingOrganisationName(britishStandard);
        britishStandardResponse.setAuthorisingOrganisationNamePart(authorisingOrganisationNamePart);

        String yearPart = appendYear(britishStandard);
        britishStandardResponse.setYearPart(yearPart);

        String titleOfStandardPart = appendTitleOfStandard(britishStandard);
        britishStandardResponse.setTitleOfStandardPart(titleOfStandardPart);

        String publisherAndPublicationPlacePart = appendPublisherAndPublicationPlace(britishStandard);
        britishStandardResponse.setPublisherAndPublicationPlacePart(publisherAndPublicationPlacePart);

        return britishStandardResponse;
    }

    private String appendAuthorisingOrganisationName(BritishStandard britishStandard) {
        return britishStandard.getAuthorisingOrganisationName().toUpperCase();
    }

    private String appendYear(BritishStandard britishStandard) {
        return " (" + britishStandard.getYear() + ")";
    }

    private String appendTitleOfStandard(BritishStandard britishStandard) {
        return " " + britishStandard.getTitleOfStandard() + ".";
    }

    private String appendPublisherAndPublicationPlace(BritishStandard britishStandard) {
        return " " + britishStandard.getPublicationPlace() + ": " + britishStandard.getPublisher() + ".";
    }
}
