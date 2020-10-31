package com.referenceit.onlinesource.socialmedia;

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
public class SocialMediaServiceTest {

    @Autowired
    private SocialMediaService socialMediaService;


    @Test
    public void shouldPassReferencingSocialMedia() {
        //given
        List<Author> authors = Arrays.asList(new Author("Sam", null, "Jones"));
        SocialMediaDto socialMediaDto = SocialMediaDto.builder()
                .authors(authors)
                .year("2015")
                .title("Referencing group")
                .websiteTitle("Facebook")
                .dayAndMonth("5th May")
                .availableFrom("www.facebook.com")
                .accessedDate("04/07/16")
                .build();

        //when
        ReferenceResponse referenceResponse = socialMediaService.generateReference(socialMediaDto);

        //then
        String expectedResult = "JONES, S. (2015) Referencing group. [Facebook] 5th May. Available from: www.facebook.com [Accessed 04/07/16].";

        assertEquals(expectedResult, referenceResponse.toString());
    }

}
