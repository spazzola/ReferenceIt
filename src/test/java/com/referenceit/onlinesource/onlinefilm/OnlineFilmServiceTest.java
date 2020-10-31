package com.referenceit.onlinesource.onlinefilm;

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
public class OnlineFilmServiceTest {

    @Autowired
    private OnlineFilmService onlineFilmService;


    @Test
    public void shouldPassReferencingOnlineFilm() {
        //given
        List<Author> authors = Arrays.asList(new Author(null, null, "Proquestrefworks"));
        OnlineFilmDto onlineFilmDto = OnlineFilmDto.builder()
                .authors(authors)
                .year("2012")
                .title("Adding references to Refworks using direct export")
                .availableFrom("http://www.youtube.com/watch?v=0CzBU5rTzGY")
                .accessedDate("17/07/13")
                .build();

        //when
        ReferenceResponse referenceResponse = onlineFilmService.generateReference(onlineFilmDto);

        //then
        String expectedResult = "PROQUESTREFWORKS (2012) Adding references to Refworks using direct export. " +
                "[Online film] Available from: http://www.youtube.com/watch?v=0CzBU5rTzGY [Accessed 17/07/13].";

        assertEquals(expectedResult, referenceResponse.toString());

    }

}
