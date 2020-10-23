package com.referenceit.newspaperarticle;

import com.referenceit.reference.Author;
import com.referenceit.reference.ReferenceService;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NewspaperArticleTest {

    private ReferenceService referenceService = new ReferenceService();
    private NewspaperArticleMapper newspaperArticleMapper = new NewspaperArticleMapper();
    private NewspaperArticleService newspaperArticleService = new NewspaperArticleService(referenceService, newspaperArticleMapper);

    public NewspaperArticleTest() {

    }


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
        NewspaperArticleResponse newspaperArticleResponse = newspaperArticleService.generateReference(newspaperArticleDto);
        String resultReference = "";
        resultReference += newspaperArticleResponse.getAuthorsPart();
        resultReference += newspaperArticleResponse.getYearPart();
        resultReference += newspaperArticleResponse.getArticleTitlePart();
        resultReference += newspaperArticleResponse.getNewspaperTitlePart();
        resultReference += newspaperArticleResponse.getDayAndMonthPart();
        resultReference += newspaperArticleResponse.getPagesPart();

        String expectedResult = "ALDRICK, P. (2014) It’s not just academic: universities could make a difference to Britain’s exports. The Times, 9th Jan. p. 45.";

        assertEquals(expectedResult, resultReference);
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
        NewspaperArticleResponse newspaperArticleResponse = newspaperArticleService.generateReference(newspaperArticleDto);
        String resultReference = "";
        resultReference += newspaperArticleResponse.getAuthorsPart();
        resultReference += newspaperArticleResponse.getYearPart();
        resultReference += newspaperArticleResponse.getArticleTitlePart();
        resultReference += newspaperArticleResponse.getNewspaperTitlePart();
        resultReference += newspaperArticleResponse.getDayAndMonthPart();
        resultReference += newspaperArticleResponse.getAvailableFromAndAccessedDatePart();

        String expectedResult = "SHARPE, J. (2016) Jamie Vardy: The complete transfer saga as England striker " +
                "turns down Arsenal for Leicester City. Leicester Mercury. [Online] 23rd June. Available from: " +
                "http://www.leicestermercury.co.uk/jamie-vardy-the-complete-transfer-saga-as-england-striker-turns-down-arsenal-for-leicester-city/story-29436003-detail/story.html " +
                "[Accessed 28/06/16].";

        assertEquals(expectedResult, resultReference);
    }
}
