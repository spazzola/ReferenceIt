package com.referenceit.onlinesource.software;

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
public class SoftwareServiceTest {

    @Autowired
    private SoftwareService softwareService;


    @Test
    public void shouldPassReferencingSoftware() {
        //given
        List<Author> authors = Arrays.asList(new Author(null, null, "SPSS"));
        SoftwareDto softwareDto = SoftwareDto.builder()
                .authors(authors)
                .year("2015")
                .title("SPSS Statistics")
                .version("22")
                .publicationPlace("Chicago")
                .publisher("SPSS")
                .build();

        //when
        ReferenceResponse referenceResponse = softwareService.generateReference(softwareDto);

        //then
        String expectedResult = "SPSS (2015) SPSS Statistics. [Software] Version 22. Chicago: SPSS.";

        assertEquals(expectedResult, referenceResponse.toString());
    }

}
