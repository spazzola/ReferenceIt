package com.referenceit.otherprintsource.britishstandard;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BritishStandardTest {

    private BritishStandardMapper britishStandardMapper = new BritishStandardMapper();
    private BritishStandardService britishStandardService = new BritishStandardService(britishStandardMapper);

    public BritishStandardTest() {

    }

    @Test
    public void shouldPassReferencingBritishStandard() {
        //given
        String authorisingOrganisationName = "British standards institute";
        String year = "2016";
        String titleOfStandard = "BS ISO 6626-1: Internal Combustion engines. Piston rings. Part 1 Coil-spring-loaded oil control rings made of cast iron";
        String publicationPlace = "London";
        String publisher = "British Standards Institute";

        BritishStandardDto britishStandardDto = BritishStandardDto.builder()
                .authorisingOrganisationName(authorisingOrganisationName)
                .year(year)
                .titleOfStandard(titleOfStandard)
                .publicationPlace(publicationPlace)
                .publisher(publisher)
                .build();

        //when
        BritishStandardResponse britishStandardResponse = britishStandardService.generateReference(britishStandardDto);
        String referenceResult = "";
        referenceResult += britishStandardResponse.getAuthorisingOrganisationNamePart();
        referenceResult += britishStandardResponse.getYearPart();
        referenceResult += britishStandardResponse.getTitleOfStandardPart();
        referenceResult += britishStandardResponse.getPublisherAndPublicationPlacePart();

        String expectedResult = "BRITISH STANDARDS INSTITUTE (2016) BS ISO 6626-1: Internal Combustion engines. Piston rings. Part 1 Coil-spring-loaded oil control rings made of cast iron. London: British Standards Institute.";

        //then
        assertEquals(expectedResult, referenceResult);

    }

}
