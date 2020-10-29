package com.referenceit.onlinesource.computergame;

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
public class ComputerGameServiceTest {

    @Autowired
    private ComputerGameService computerGameService;


    @Test
    public void shouldPassReferencingComputerGame() {
        //given
        List<Author> authors = Arrays.asList(new Author(null, null, "ELECTRONIC ARTS"));
        ComputerGameDto computerGameDto = ComputerGameDto.builder()
                .authors(authors)
                .year("2003")
                .title("The Sims")
                .mediumOfItem("CD")
                .platform("PlayStation2")
                .publicationPlace("London")
                .publisher("Electronic Arts Inc")
                .build();

        //when
        ComputerGameResponse computerGameResponse = computerGameService.generateReference(computerGameDto);
        String referenceResult = "";
        referenceResult += computerGameResponse.getAuthorAndYearPart();
        referenceResult += computerGameResponse.getTitlepart();
        referenceResult += computerGameResponse.getRestReferenceBodyPart();

        //then
        String expectedResult = "ELECTRONIC ARTS (2003) The Sims. [CD] PlayStation2. London: Electronic Arts Inc.";

        assertEquals(expectedResult, referenceResult);
    }

}
