package com.referenceit.otherprintsource.conferenceproceedings;

import com.referenceit.otherprintsource.conferenceproceeding.ConferenceProceedingDto;
import com.referenceit.otherprintsource.conferenceproceeding.ConferenceProceedingResponse;
import com.referenceit.otherprintsource.conferenceproceeding.ConferenceProceedingService;
import com.referenceit.reference.Author;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ConferenceProceedingServiceTest {

    @Autowired
    private ConferenceProceedingService conferenceProceedingService;


    @Test
    public void shouldPassReferencingConferenceProceeding() {
        //given
        List<Author> authors = Arrays.asList(
                new Author("Mat", null, "Huffmeyer"),
                new Author("Ulan", null, "Schreier"));

        ConferenceProceedingDto conferenceProceedingDto = ConferenceProceedingDto.builder()
                .authors(authors)
                .year("2016")
                .publicationPlace("New York")
                .publisher("ACM")
                .title("RestACL: An access control language for RESTful services")
                .titleOfConferenceProceedings("Proceedings of the 2016 ACM International Workshop on attribute Based Access Control")
                .place("New Orleans")
                .monthAndYear("March 2016")
                .pages("58-67")
                .build();


        //when
        ConferenceProceedingResponse conferenceProceedingResponse = conferenceProceedingService.generateReference(conferenceProceedingDto);
        String resultReference = "";
        resultReference += conferenceProceedingResponse.getAuthorsPart();
        resultReference += conferenceProceedingResponse.getYearPart();
        resultReference += conferenceProceedingResponse.getTitlePart();
        resultReference += conferenceProceedingResponse.getTitleOfConferenceProceedingsPart();
        resultReference += conferenceProceedingResponse.getPlaceAndDatePart();
        resultReference += conferenceProceedingResponse.getPublicationPlaceAndPublisherPart();
        resultReference += conferenceProceedingResponse.getPages();

        String expectedResult = "HUFFMEYER, M. and SCHREIER, U. (2016) RestACL: An access control language for RESTful services. " +
                "In: Proceedings of the 2016 ACM International Workshop on attribute Based Access Control, New Orleans, March 2016. New York: ACM, pp. 58-67.";

        //then
        assertEquals(expectedResult, resultReference);
    }

}
