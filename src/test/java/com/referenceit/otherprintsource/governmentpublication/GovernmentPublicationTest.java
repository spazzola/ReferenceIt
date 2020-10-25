package com.referenceit.otherprintsource.governmentpublication;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GovernmentPublicationTest {

    private GovernmentPublicationMapper governmentPublicationMapper = new GovernmentPublicationMapper();
    private GovernmentPublicationService governmentPublicationService = new GovernmentPublicationService(governmentPublicationMapper);

    public GovernmentPublicationTest() {

    }


    @Test
    public void ShouldPassReferencingGovernmentPublicationKnowByGovernment() {
        //given
        GovernmentPublicationDto governmentPublicationDto = GovernmentPublicationDto.builder()
                .knowBy("government")
                .year("1988")
                .publicationPlace("London")
                .publisher("HMSO")
                .title("Report of the enquiry into child abuse in Cleveland")
                .nameOfIssuingBody("Great Britain. Department of Health and Social Security")
                .reportNumber("Cm413")
                .build();

        //when
        GovernmentPublicationResponse governmentPublicationResponse = governmentPublicationService.generateReference(governmentPublicationDto);
        String resultReference = "";
        resultReference += governmentPublicationResponse.getNameOfIssuingBodyAndYearPart();
        resultReference += governmentPublicationResponse.getTitlePart();
        resultReference += governmentPublicationResponse.getPublicationPlaceAndPublisherPart();
        resultReference += governmentPublicationResponse.getReportNumberPart();

        //then
        String expectedResult = "GREAT BRITAIN. DEPARTMENT OF HEALTH AND SOCIAL SECURITY (1988) Report of the enquiry into child abuse in Cleveland. London: HMSO, Cm413.";

        assertEquals(expectedResult, resultReference);

    }

    @Test
    public void ShouldPassReferencingGovernmentPublicationKnowByTitle() {
        //given
        GovernmentPublicationDto governmentPublicationDto = GovernmentPublicationDto.builder()
                .knowBy("title")
                .year("1988")
                .nameOfIssuingBody("Great Britain. Department of Health and Social Security")
                .nameOfKnowBy("The Cleveland Enquiry")
                .build();

        //when
        GovernmentPublicationResponse governmentPublicationResponse = governmentPublicationService.generateReference(governmentPublicationDto);
        String resultReference = "";
        resultReference += governmentPublicationResponse.getNameOfKnowByPart();
        resultReference += governmentPublicationResponse.getNameOfIssuingBodyAndYearPart();

        //then
        String expectedResult = "The Cleveland Enquiry - see GREAT BRITAIN. DEPARTMENT OF HEALTH AND SOCIAL SECURITY (1988).";

        assertEquals(expectedResult, resultReference);

    }

    @Test
    public void ShouldPassReferencingGovernmentPublicationKnowByChairman() {
        //given
        GovernmentPublicationDto governmentPublicationDto = GovernmentPublicationDto.builder()
                .knowBy("chairman")
                .year("1992")
                .nameOfIssuingBody("Committee on the financial aspects of corporate governance")
                .nameOfKnowBy("Cadbury report")
                .build();

        //when
        GovernmentPublicationResponse governmentPublicationResponse = governmentPublicationService.generateReference(governmentPublicationDto);
        String resultReference = "";
        resultReference += governmentPublicationResponse.getNameOfKnowByPart();
        resultReference += governmentPublicationResponse.getNameOfIssuingBodyAndYearPart();

        //then
        String expectedResult = "Cadbury report - see COMMITTEE ON THE FINANCIAL ASPECTS OF CORPORATE GOVERNANCE (1992).";

        assertEquals(expectedResult, resultReference);

    }
}
