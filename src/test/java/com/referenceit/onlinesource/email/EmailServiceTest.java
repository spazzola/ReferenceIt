package com.referenceit.onlinesource.email;

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
public class EmailServiceTest {

    @Autowired
    private EmailService emailService;


    @Test
    public void shouldPassReferencingEmail() {
        //given
        List<Author> authors = Arrays.asList(new Author("Patrick", null, "Manson"));
        EmailDto emailDto = EmailDto.builder()
                .authors(authors)
                .year("2015")
                .title("Harvard University encourages open access")
                .electronicConference("Library and information professionals discussion list")
                .dayAndMonth("14th Sept.")
                .availableFrom("http://www.jiscmail.ac.uk/lists/LISprofession.html")
                .accessedDate("28/06/16")
                .build();

        //when
        EmailResponse emailResponse = emailService.generateReference(emailDto);
        String referenceResult = "";
        referenceResult += emailResponse.getAuthorAndYearPart();
        referenceResult += emailResponse.getTitlePart();
        referenceResult += emailResponse.getElectronicConference();
        referenceResult += emailResponse.getRestReferenceBodyPart();

        //then
        String expectedResult = "MANSON, P. (2015) Harvard University encourages open access. [Online] Library and information professionals discussion list, 14th Sept. " +
                "Available from: http://www.jiscmail.ac.uk/lists/LISprofession.html [Accessed 28/06/16].";

        assertEquals(expectedResult, referenceResult);
    }

}
