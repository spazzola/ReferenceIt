package com.referenceit.onlinesource.marketresearch;

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
public class MarketResearchServiceTest {

    @Autowired
    private MarketResearchService marketResearchService;


    @Test
    public void shouldPassReferencingMarketResearchServiceWithDateAndWithoutEdition() {
        //given
        List<Author> authors = Arrays.asList(new Author(null, null, "MINTEL OXYGEN"));
        MarketResearchDto marketResearchDto = MarketResearchDto.builder()
                .authors(authors)
                .year("2020")
                .title("Cider - UK")
                .date("February 2020")
                .availableFrom("https://reports.mintel.com/display/987702/?fromSearch=%3Ffreetext%3Dcider%2520uk")
                .accessedDate("13/05/20")
                .build();

        //when
        ReferenceResponse referenceResponse = marketResearchService.generateReference(marketResearchDto);

        //then
        String expectedResult = "MINTEL OXYGEN (2020) Cider - UK, February 2020. [Online] " +
                "Available from: https://reports.mintel.com/display/987702/?fromSearch=%3Ffreetext%3Dcider%2520uk [Accessed 13/05/20].";

        assertEquals(expectedResult, referenceResponse.toString());
    }

    @Test
    public void shouldPassReferencingMarketResearchServiceWithDateAndWithEdition() {
        //given
        List<Author> authors = Arrays.asList(new Author(null, null, "MINTEL OXYGEN"));
        MarketResearchDto marketResearchDto = MarketResearchDto.builder()
                .authors(authors)
                .year("2020")
                .title("Cider - UK")
                .date("February 2020")
                .edition("3")
                .availableFrom("https://reports.mintel.com/display/987702/?fromSearch=%3Ffreetext%3Dcider%2520uk")
                .accessedDate("13/05/20")
                .build();

        //when
        ReferenceResponse referenceResponse = marketResearchService.generateReference(marketResearchDto);

        //then
        String expectedResult = "MINTEL OXYGEN (2020) Cider - UK, February 2020. 3rd ed. [Online] " +
                "Available from: https://reports.mintel.com/display/987702/?fromSearch=%3Ffreetext%3Dcider%2520uk [Accessed 13/05/20].";

        assertEquals(expectedResult, referenceResponse.toString());
    }

    @Test
    public void shouldPassReferencingMarketResearchServiceWithoutDateAndWithoutEdition() {
        //given
        List<Author> authors = Arrays.asList(new Author(null, null, "MINTEL OXYGEN"));
        MarketResearchDto marketResearchDto = MarketResearchDto.builder()
                .authors(authors)
                .year("2020")
                .title("Cider - UK")
                .availableFrom("https://reports.mintel.com/display/987702/?fromSearch=%3Ffreetext%3Dcider%2520uk")
                .accessedDate("13/05/20")
                .build();

        //when
        ReferenceResponse referenceResponse = marketResearchService.generateReference(marketResearchDto);

        //then
        String expectedResult = "MINTEL OXYGEN (2020) Cider - UK. [Online] " +
                "Available from: https://reports.mintel.com/display/987702/?fromSearch=%3Ffreetext%3Dcider%2520uk [Accessed 13/05/20].";

        assertEquals(expectedResult, referenceResponse.toString());
    }

    @Test
    public void shouldPassReferencingMarketResearchServiceWithoutDateAndEdition() {
        //given
        List<Author> authors = Arrays.asList(new Author(null, null, "MINTEL OXYGEN"));
        MarketResearchDto marketResearchDto = MarketResearchDto.builder()
                .authors(authors)
                .year("2020")
                .title("Cider - UK")
                .edition("2")
                .availableFrom("https://reports.mintel.com/display/987702/?fromSearch=%3Ffreetext%3Dcider%2520uk")
                .accessedDate("13/05/20")
                .build();

        //when
        ReferenceResponse referenceResponse = marketResearchService.generateReference(marketResearchDto);

        //then
        String expectedResult = "MINTEL OXYGEN (2020) Cider - UK. 2nd ed. [Online] " +
                "Available from: https://reports.mintel.com/display/987702/?fromSearch=%3Ffreetext%3Dcider%2520uk [Accessed 13/05/20].";

        assertEquals(expectedResult, referenceResponse.toString());
    }

}
