package com.referenceit.onlinesource.blog;

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
public class BlogServiceTest {

    @Autowired
    private BlogService blogService;


    @Test
    public void shouldPassReferencingBlogWithPostingTitle() {
        //given
        List<Author> authors = Arrays.asList(new Author(null, null, "TRANSPORTATION SECURITY ADMINISTRATION"));
        BlogDto blogDto = BlogDto.builder()
                .authors(authors)
                .year("2016")
                .postingTitle("#TSATravelSafe – improving your checkpoint experience & keeping you safe")
                .siteTitle("The TSA Blog")
                .dayAndMonth("3rd June")
                .availableFrom("http://blog.tsa.gov/2016/06/tsatravelsafe-improving-your-checkpoint.html")
                .accessedDate("28/06/16")
                .build();

        //when
        BlogResponse blogResponse = blogService.generateReference(blogDto);
        String referenceResult = "";
        referenceResult += blogResponse.getAuthorYearAndPostingTitlePart();
        referenceResult += blogResponse.getSiteTitlePart();
        referenceResult += blogResponse.getRestReferenceBodyPart();

        //then
        String expectedResult = "TRANSPORTATION SECURITY ADMINISTRATION (2016) #TSATravelSafe – improving your checkpoint experience & keeping you safe. " +
                "[Weblog] The TSA Blog. 3rd June. Available from: http://blog.tsa.gov/2016/06/tsatravelsafe-improving-your-checkpoint.html [Accessed 28/06/16].";

        assertEquals(expectedResult, referenceResult);
    }


    @Test
    public void shouldPassReferencingBlogWithoutPostingTitle() {
        //given
        List<Author> authors = Arrays.asList(new Author(null, null, "TRANSPORTATION SECURITY ADMINISTRATION"));
        BlogDto blogDto = BlogDto.builder()
                .authors(authors)
                .year("2016")
                .siteTitle("The TSA Blog")
                .dayAndMonth("3rd June")
                .availableFrom("http://blog.tsa.gov/2016/06/tsatravelsafe-improving-your-checkpoint.html")
                .accessedDate("28/06/16")
                .build();

        //when
        BlogResponse blogResponse = blogService.generateReference(blogDto);
        String referenceResult = "";
        referenceResult += blogResponse.getAuthorYearAndPostingTitlePart();
        referenceResult += blogResponse.getSiteTitlePart();
        referenceResult += blogResponse.getRestReferenceBodyPart();

        //then
        String expectedResult = "TRANSPORTATION SECURITY ADMINISTRATION (2016) " +
                "[Weblog] The TSA Blog. 3rd June. Available from: http://blog.tsa.gov/2016/06/tsatravelsafe-improving-your-checkpoint.html [Accessed 28/06/16].";

        assertEquals(expectedResult, referenceResult);
    }

}
