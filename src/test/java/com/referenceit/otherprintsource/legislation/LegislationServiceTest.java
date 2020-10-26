package com.referenceit.otherprintsource.legislation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LegislationServiceTest {

    private LegislationMapper legislationMapper = new LegislationMapper();
    private LegislationService legislationService = new LegislationService(legislationMapper);


    @Test
    public void shouldPassReferencingActOfParliament() {
        //given
        LegislationDto legislationDto = LegislationDto.builder()
                .year("2005")
                .chapterNumber("25")
                .publicationPlace("London")
                .publisher("The Stationery Office")
                .title("Environment Act")
                .isParliamentAct(true)
                .build();

        //when
        LegislationResponse legislationResponse = legislationService.generateReference(legislationDto);
        String referenceResult = "";
        referenceResult += legislationResponse.getTitleAndYearPart();
        referenceResult += legislationResponse.getChapterPart();
        referenceResult += legislationResponse.getPublisherAndPublicationPlacePart();

        //then
        String expectedResult = "Environment Act 2005 (c.25). London: The Stationery Office.";

        assertEquals(expectedResult, referenceResult);
    }

    @Test
    public void shouldPassReferencingStatutoryInstruments() {
        //given
        LegislationDto legislationDto = LegislationDto.builder()
                .year("1986")
                .chapterNumber("25")
                .publicationPlace("London")
                .publisher("HMSO")
                .title("Insolvency Rules")
                .siYearNumber("1986/925")
                .isParliamentAct(false)
                .build();

        //when
        LegislationResponse legislationResponse = legislationService.generateReference(legislationDto);
        String referenceResult = "";
        referenceResult += legislationResponse.getTitleAndYearPart();
        referenceResult += legislationResponse.getSiOrYearNumber();
        referenceResult += legislationResponse.getPublisherAndPublicationPlacePart();

        //then
        String expectedResult = "Insolvency Rules 1986 (SI 1986/925). London: HMSO.";

        assertEquals(expectedResult, referenceResult);
    }
}
