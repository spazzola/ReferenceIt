package com.referenceit.otherprintsource.governmentpublication;

import com.referenceit.reference.ReferenceResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@RunWith(SpringRunner.class)
public class GovernmentPublicationServiceTest {

    @Autowired
    private GovernmentPublicationService governmentPublicationService;


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
        ReferenceResponse referenceResponse = governmentPublicationService.generateReference(governmentPublicationDto);

        //then
        String expectedResult = "GREAT BRITAIN. DEPARTMENT OF HEALTH AND SOCIAL SECURITY (1988) Report of the enquiry into child abuse in Cleveland. London: HMSO, Cm413.";

        assertEquals(expectedResult, referenceResponse.toString());

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
        ReferenceResponse referenceResponse = governmentPublicationService.generateReference(governmentPublicationDto);

        //then
        String expectedResult = "The Cleveland Enquiry - see GREAT BRITAIN. DEPARTMENT OF HEALTH AND SOCIAL SECURITY (1988).";

        assertEquals(expectedResult, referenceResponse.toString());

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
        ReferenceResponse referenceResponse = governmentPublicationService.generateReference(governmentPublicationDto);

        //then
        String expectedResult = "Cadbury report - see COMMITTEE ON THE FINANCIAL ASPECTS OF CORPORATE GOVERNANCE (1992).";

        assertEquals(expectedResult, referenceResponse.toString());

    }

}
