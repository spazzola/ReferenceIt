package com.referenceit.onlinesource.onlineimage;

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
public class OnlineImageServiceTest {

    @Autowired
    private OnlineImageService onlineImageService;


    @Test
    public void shouldPassReferencingOnlineImage() {
        //given
        List<Author> authors = Arrays.asList(new Author(null, null, "JSCREATIONZS"));
        OnlineImageDto onlineImageDto = OnlineImageDto.builder()
                .authors(authors)
                .year("2012")
                .title("Gears concept")
                .availableFrom("www.freedigitalphotos.net/ images/search.php?searc")
                .accessedDate("19/06/13")
                .build();

        //when
        ReferenceResponse referenceResponse = onlineImageService.generateReference(onlineImageDto);

        //then
        String expectedResult = "JSCREATIONZS (2012) Gears concept. [Online image] " +
                "Available from: www.freedigitalphotos.net/ images/search.php?searc [Accessed 19/06/13].";

        assertEquals(expectedResult, referenceResponse.toString());
    }

}
