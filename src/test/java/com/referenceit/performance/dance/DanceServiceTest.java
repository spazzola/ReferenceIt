package com.referenceit.performance.dance;

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
public class DanceServiceTest {

    @Autowired
    private DanceService danceService;


    @Test
    public void shouldPassReferencingDance() {
        //given
        List<Author> authors = Arrays.asList(new Author("Franklin", null, "Ashton"));
        DanceDto danceDto = DanceDto.builder()
                .authors(authors)
                .year("1948")
                .title("Cinderella")
                .location("Royal Opera House, London")
                .seenDate("13th January 2004")
                .build();

        //when
        DanceResponse danceResponse = danceService.generateReference(danceDto);
        String referenceResult = "";
        referenceResult += danceResponse.getAuthorAndYearPart();
        referenceResult += danceResponse.getTitlePart();
        referenceResult += danceResponse.getRestReferenceBodyPart();

        //then
        String expectedResult = "ASHTON, F. (1948) Cinderella. [Royal Opera House, London, 13th January 2004].";

        assertEquals(expectedResult, referenceResult);
    }

}
