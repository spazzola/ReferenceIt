package com.referenceit.otherprintsource.britishstandard;

import com.referenceit.reference.ReferenceResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class BritishStandardService {

    private BritishStandardMapper britishStandardMapper;


    public ReferenceResponse generateReference(BritishStandardDto britishStandardDto) {
        BritishStandard britishStandard = britishStandardMapper.fromDto(britishStandardDto);

        return createReference(britishStandard);
    }

    private ReferenceResponse createReference(BritishStandard britishStandard) {
        ReferenceResponse referenceResponse = new ReferenceResponse();

        String authorisingOrganisationNamePart = appendAuthorisingOrganisationName(britishStandard);
        String yearPart = appendYear(britishStandard);
        referenceResponse.setFirstPartNormal(authorisingOrganisationNamePart + yearPart);

        String titleOfStandardPart = appendTitleOfStandard(britishStandard);
        referenceResponse.setItalicsPart(titleOfStandardPart);

        String publisherAndPublicationPlacePart = appendPublisherAndPublicationPlace(britishStandard);
        referenceResponse.setThirdPartNormal(publisherAndPublicationPlacePart);

        return referenceResponse;
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
