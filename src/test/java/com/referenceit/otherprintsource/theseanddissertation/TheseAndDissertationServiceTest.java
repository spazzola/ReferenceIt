package com.referenceit.otherprintsource.theseanddissertation;

import com.referenceit.reference.Author;
import com.referenceit.reference.ReferenceResponse;
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
public class TheseAndDissertationServiceTest {

    @Autowired
    private TheseAndDissertationService theseAndDissertationService;


    @Test
    public void shouldPassReferencingTheseAndDissertation() {
        //given
        List<Author> authors = Arrays.asList(new Author("Adam", null, "Nederberg"));
        TheseAndDissertationDto theseAndDissertationDto = TheseAndDissertationDto.builder()
                .authors(authors)
                .year("2012")
                .title("Corporeality in music for contemporary dance")
                .designation("Thesis")
                .degreeLevel("Ma")
                .institution("De Montfort University")
                .build();


        //when
        ReferenceResponse referenceResponse = theseAndDissertationService.generateReference(theseAndDissertationDto);

        //then
        String expectedResult = "NEDERBERG, A. (2012) Corporeality in music for contemporary dance. Thesis (MA), De Montfort University.";

        assertEquals(expectedResult, referenceResponse.toString());
    }

}
