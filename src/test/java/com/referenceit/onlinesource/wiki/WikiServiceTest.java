package com.referenceit.onlinesource.wiki;

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
public class WikiServiceTest {

    @Autowired
    private WikiService wikiService;


    @Test
    public void shouldPassReferencingWiki() {
        //given
        List<Author> authors = Arrays.asList(new Author(null, null, "INFOTEACH"));
        WikiDto wikiDto = WikiDto.builder()
                .authors(authors)
                .year("2007")
                .title("Learning_outcomes")
                .availableFrom("http://infoteach.org/wiki/doku. php/learning_outcomes")
                .accessedDate("18/04/13")
                .build();

        //when
        WikiResponse wikiResponse = wikiService.generateReference(wikiDto);
        String referenceResult = "";
        referenceResult += wikiResponse.getAuthorAndYearPart();
        referenceResult += wikiResponse.getTitle();
        referenceResult += wikiResponse.getRestReferenceBodyPart();

        //then
        String expectedResult = "INFOTEACH (2007) Learning_outcomes. [Online] " +
                "Available from: http://infoteach.org/wiki/doku. php/learning_outcomes [Accessed 18/04/13].";

        assertEquals(expectedResult, referenceResult);
    }

}
