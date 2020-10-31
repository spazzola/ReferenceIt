package com.referenceit.newspaperarticle;

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
public class NewspaperArticleServiceTest {

    @Autowired
    private NewspaperArticleService newspaperArticleService;


    @Test
    public void shouldPassReferencingNewspaperArticleWithOneAuthorNotOnlineSource() {
        //given
        List<Author> authors = Arrays.asList(new Author("Pamon", null, "Aldrick"));

        NewspaperArticleDto newspaperArticleDto = NewspaperArticleDto.builder()
                .authors(authors)
                .year("2014")
                .articleTitle("It’s not just academic: universities could make a difference to Britain’s exports")
                .newspaperTitle("The Times")
                .pages("45")
                .day("9")
                .month("January")
                .build();

        //when
        ReferenceResponse referenceResponse = newspaperArticleService.generateReference(newspaperArticleDto);

        String expectedResult = "ALDRICK, P. (2014) It’s not just academic: universities could make a difference to Britain’s exports. The Times, 9th Jan. p. 45.";

        assertEquals(expectedResult, referenceResponse.toString());
    }

    @Test
    public void shouldPassReferencingNewspaperArticleWithOneAuthorOnlineSource() {
        //given
        List<Author> authors = Arrays.asList(new Author("Jon", null, "Sharpe"));

        NewspaperArticleDto newspaperArticleDto = NewspaperArticleDto.builder()
                .authors(authors)
                .year("2016")
                .articleTitle("Jamie Vardy: The complete transfer saga as England striker turns down Arsenal for Leicester City")
                .newspaperTitle("Leicester Mercury")
                .day("23")
                .month("June")
                .availableFrom("http://www.leicestermercury.co.uk/jamie-vardy-the-complete-transfer-saga-as-england-striker-turns-down-arsenal-for-leicester-city/story-29436003-detail/story.html")
                .accessedDate("28/06/16")
                .isOnlyAvailableOnline(true)
                .build();

        //when
        ReferenceResponse referenceResponse = newspaperArticleService.generateReference(newspaperArticleDto);

        String expectedResult = "SHARPE, J. (2016) Jamie Vardy: The complete transfer saga as England striker " +
                "turns down Arsenal for Leicester City. Leicester Mercury. [Online] 23rd June. Available from: " +
                "http://www.leicestermercury.co.uk/jamie-vardy-the-complete-transfer-saga-as-england-striker-turns-down-arsenal-for-leicester-city/story-29436003-detail/story.html " +
                "[Accessed 28/06/16].";

        assertEquals(expectedResult, referenceResponse.toString());
    }

}
