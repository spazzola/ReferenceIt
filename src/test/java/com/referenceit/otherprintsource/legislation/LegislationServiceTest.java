package com.referenceit.otherprintsource.legislation;

import com.referenceit.reference.ReferenceResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@RunWith(SpringRunner.class)
public class LegislationServiceTest {

    @Autowired
    private LegislationService legislationService;


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
        ReferenceResponse referenceResponse = legislationService.generateReference(legislationDto);

        //then
        String expectedResult = "Environment Act 2005 (c.25). London: The Stationery Office.";

        assertEquals(expectedResult, referenceResponse.toString());
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
        ReferenceResponse referenceResponse = legislationService.generateReference(legislationDto);

        //then
        String expectedResult = "Insolvency Rules 1986 (SI 1986/925). London: HMSO.";

        assertEquals(expectedResult, referenceResponse.toString());
    }

}
