package com.referenceit.otherprintsource.exhibition;

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
public class ExhibitionServiceTest {

    @Autowired
    private ExhibitionService exhibitionService;


    @Test
    public void shouldPassReferencingExhibitionCatalogue() {
        //given
        List<Author> authors = Arrays.asList(new Author("Williams", null, "Harris"));
        ExhibitionDto exhibitionDto = ExhibitionDto.builder()
                .authors(authors)
                .year("1983")
                .title("William Harris as designer")
                .exhibitionCatalogue("")
                .location("Whitworth Art Gallery")
                .date("3 May – 4 June 1983")
                .publicationPlace("London")
                .publisher("Arts Council")
                .isItemFromExhibition(false)
                .build();

        //when
        ReferenceResponse referenceResponse = exhibitionService.generateReference(exhibitionDto);

        //then
        String expectedResult = "HARRIS, W. (1983) William Harris as designer. [Catalogue of an exhibition held at the Whitworth Art Gallery, 3 May – 4 June 1983] London: Arts Council.";

        assertEquals(expectedResult, referenceResponse.toString());
    }


    @Test
    public void shouldPassReferencingExhibitionItem() {
        //given
        List<Author> authors = Arrays.asList(new Author("Adam", null, "Calder"));
        ExhibitionDto exhibitionDto = ExhibitionDto.builder()
                .authors(authors)
                .year("c.1953")
                .title("Antennae with Red and Blue Dots")
                .itemType("Sculpture")
                .location("Tate Modern, London")
                .date("15th December 2015")
                .isItemFromExhibition(true)
                .build();

        //when
        ReferenceResponse referenceResponse = exhibitionService.generateReference(exhibitionDto);

        //then
        String expectedResult = "CALDER, A. (c.1953) Antennae with Red and Blue Dots. [Sculpture] [Tate Modern, London, 15th December 2015].";

        assertEquals(expectedResult, referenceResponse.toString());
    }

}
