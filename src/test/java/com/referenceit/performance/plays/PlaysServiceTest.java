package com.referenceit.performance.plays;

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
public class PlaysServiceTest {

    @Autowired
    private PlaysService playsService;


    @Test
    public void shouldPassReferencingDance() {
        //given
        List<Author> authors = Arrays.asList(new Author("Jeremy", "Bob", "Priestley"));
        PlaysDto playsDto = PlaysDto.builder()
                .authors(authors)
                .year("2009")
                .title("An inspector calls")
                .directorName("Stephen Daldry")
                .location("Arts Theatre, Cambridge")
                .seenDate("11th May 2009")
                .build();

        //when
        ReferenceResponse referenceResponse = playsService.generateReference(playsDto);

        //then
        String expectedResult = "An inspector calls by J.B. Priestley. (2009) Directed by STEPHEN DALDRY. [Arts Theatre, Cambridge, 11th May 2009].";

        assertEquals(expectedResult, referenceResponse.toString());
    }

}
