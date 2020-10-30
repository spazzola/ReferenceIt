package com.referenceit.onlinesource.webpage;

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
public class WebPageServiceTest {

    @Autowired
    private WebPageService webPageService;


    @Test
    public void shouldPassReferencingWebPage() {
        //given
        List<Author> authors = Arrays.asList(new Author(null, null, "NHS"));
        WebPageDto webPageDto = WebPageDto.builder()
                .authors(authors)
                .year("2016")
                .title("Mobile phone safety")
                .responsibleOrganisation("NHS")
                .availableFrom("http://www.nhs.uk/conditions/Mobile-phone-safety/Pages/Introduction.aspx")
                .accessedDate("28/06/16")
                .build();

        //when
        WebPageResponse webPageResponse = webPageService.generateReference(webPageDto);
        String referenceResult = "";
        referenceResult += webPageResponse.getAuthorAndYearPart();
        referenceResult += webPageResponse.getTitlePart();
        referenceResult += webPageResponse.getRestReferenceBodyPart();

        //then
        String expectedResult = "NHS (2016) Mobile phone safety. [Online] NHS. " +
                "Available from: http://www.nhs.uk/conditions/Mobile-phone-safety/Pages/Introduction.aspx [Accessed 28/06/16].";

        assertEquals(expectedResult, referenceResult);
    }

}
